package com.nayzak_shop.account_service.controller;

import com.nayzak_shop.account_service.dto.APICustomize;
import com.nayzak_shop.account_service.dto.request.LoginRequest;
import com.nayzak_shop.account_service.dto.request.RegisterRequest;
import com.nayzak_shop.account_service.dto.response.AccountsReponse;
import com.nayzak_shop.account_service.dto.response.LoginResponse;
import com.nayzak_shop.account_service.dto.response.RegisterResponse;
import com.nayzak_shop.account_service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@Validated
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        APICustomize<LoginResponse> response = accountService.authenticateUser(loginRequest);
        return ResponseEntity.status(Integer.parseInt(response.getStatusCode())).body(response);
    }

    @PostMapping("/public/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        APICustomize<RegisterResponse> response = accountService.register(registerRequest);
        return ResponseEntity.status(Integer.parseInt(response.getStatusCode())).body(response);
    }

    @GetMapping("/admin/accounts")
    public ResponseEntity<?> accounts(){
        APICustomize<List<AccountsReponse>> response = accountService.accounts();
        return ResponseEntity.status(Integer.parseInt(response.getStatusCode())).body(response.getResult());
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable long id) {
        APICustomize<String> response = accountService.deleteAccount(id);
        return ResponseEntity.status(Integer.parseInt(response.getStatusCode())).body(response);
    }

}
