package com.nayzak_shop.account_service.service;

import com.nayzak_shop.account_service.dto.APICustomize;
import com.nayzak_shop.account_service.dto.request.LoginRequest;
import com.nayzak_shop.account_service.dto.request.RegisterRequest;
import com.nayzak_shop.account_service.dto.response.AccountsReponse;
import com.nayzak_shop.account_service.dto.response.LoginResponse;
import com.nayzak_shop.account_service.dto.response.RegisterResponse;

import java.util.List;

public interface AccountService {

    public APICustomize<List<AccountsReponse>> accounts();

    public APICustomize<LoginResponse> authenticateUser(LoginRequest loginRequest);

    public APICustomize<RegisterResponse> register(RegisterRequest registerRequest);

    public APICustomize<String> deleteAccount(long id);
}
