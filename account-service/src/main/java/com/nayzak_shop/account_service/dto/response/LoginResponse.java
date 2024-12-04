package com.nayzak_shop.account_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String username;
    private List<String> roles;
    private String jwtToken;
    private String refreshToken;
}
