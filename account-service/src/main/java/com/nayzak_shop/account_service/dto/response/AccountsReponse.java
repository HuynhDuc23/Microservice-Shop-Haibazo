package com.nayzak_shop.account_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountsReponse {
    public String username;
    public String password;
    public String role;
    public boolean enabled;
}