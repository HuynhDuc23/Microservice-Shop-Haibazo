package com.nayzak_shop.api_gateway.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;

    private static final String[] PUBLIC_ENDPOINTS = {
            "/api/account/public/**",
            "/api/ecommerce/public/**"
    };

    private static final String[] ADMIN_ENDPOINTS = {
            "/api/account/admin/**",
            "/api/ecommerce/admin/**"
    };

    private static final String[] USER_ENDPOINTS = {
            "/api/account/user/**",
            "/api/ecommerce/user/**"
    };

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(PUBLIC_ENDPOINTS).permitAll()
                        .pathMatchers(ADMIN_ENDPOINTS).hasAuthority("ROLE_ADMIN")
                        .pathMatchers(USER_ENDPOINTS).hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")

                        .anyExchange().authenticated()
                )
                .addFilterAt(new JwtAuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .build();
    }

    private class JwtAuthenticationFilter implements WebFilter {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            // Nếu không có token hoặc token không phải là Bearer token, tiếp tục chain
            if (token == null || !token.startsWith("Bearer ")) {
                return chain.filter(exchange);
            }

            token = token.substring(7);

            try {
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(jwtSecret)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                String username = claims.getSubject();
                List<String> roles = claims.get("roles", List.class);

                if (roles == null || roles.isEmpty()) {
                    return chain.filter(exchange);
                }

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        username, null, roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                );

                return chain.filter(exchange)
                        .contextWrite(ReactiveSecurityContextHolder.withAuthentication(authToken));

            } catch (Exception e) {
                return exchange.getResponse().setComplete();
            }
        }
    }

}
