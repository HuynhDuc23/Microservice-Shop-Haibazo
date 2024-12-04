package com.nayzak_shop.account_service.service.impl;

import com.nayzak_shop.account_service.dto.APICustomize;
import com.nayzak_shop.account_service.dto.request.LoginRequest;
import com.nayzak_shop.account_service.dto.request.RegisterRequest;
import com.nayzak_shop.account_service.dto.response.AccountsReponse;
import com.nayzak_shop.account_service.dto.response.LoginResponse;
import com.nayzak_shop.account_service.dto.response.RegisterResponse;
import com.nayzak_shop.account_service.enums.ApiError;
import com.nayzak_shop.account_service.exception.AccountNotExist;
import com.nayzak_shop.account_service.exception.ErrorLoginException;
import com.nayzak_shop.account_service.exception.PasswordNotMatchException;
import com.nayzak_shop.account_service.exception.UserExistException;
import com.nayzak_shop.account_service.model.Account;
import com.nayzak_shop.account_service.repository.AccountRepository;
import com.nayzak_shop.account_service.security.JwtUtils;
import com.nayzak_shop.account_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Override
    public APICustomize<List<AccountsReponse>> accounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountsReponse> accountsResponses = accounts.stream()
                .map(account -> new AccountsReponse(
                        account.getUsername(),
                        account.getPassword(),
                        account.getRole(),
                        account.isEnabled()
                ))
                .toList();

        return new APICustomize<>(ApiError.OK.getCode(), ApiError.OK.getMessage(), accountsResponses);
    }

    @Override
    public APICustomize<LoginResponse> authenticateUser(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Lấy danh sách roles từ authorities
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            // Tạo JWT token với roles
            String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

            String refreshToken = jwtUtils.generateRefreshTokenFromUsername(userDetails);

            LoginResponse response = new LoginResponse(userDetails.getUsername(), roles, jwtToken, refreshToken);

            return new APICustomize<>(ApiError.OK.getCode(), ApiError.OK.getMessage(), response);
        } catch (BadCredentialsException e) {
            throw new ErrorLoginException("Wrong username or password");
        }
    }

    @Override
    public APICustomize<RegisterResponse> register(RegisterRequest registerRequest) {

        if (accountRepository.existsByUsername(registerRequest.getUsername())) {
            throw new UserExistException("Username is exist");
        }

        if(!registerRequest.getPassword().equals(registerRequest.getRePassword())){
            throw new PasswordNotMatchException("Password not match");
        }

        Account newUser = new Account();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setEnabled(true);
        newUser.setRole("ROLE_USER");

        accountRepository.save(newUser);

        RegisterResponse response = new RegisterResponse(
                newUser.getUsername(),
                newUser.getPassword(),
                "Register Successfully"
        );

        return new APICustomize<>(ApiError.CREATED.getCode(), ApiError.CREATED.getMessage(), response);
    }

    @Override
    public APICustomize<String> deleteAccount(long id){
        if(!accountRepository.existsById(id)){
            throw new AccountNotExist("Account Not exist with id = " + id);
        }
        accountRepository.deleteById(id);
        return new APICustomize<>(ApiError.NO_CONTENT.getCode(), ApiError.NO_CONTENT.getMessage(), "Delete successfully account with id = " + id);
    }
}
