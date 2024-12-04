package com.nayzak_shop.account_service.exception;

public class AccountNotExist extends RuntimeException{

    public AccountNotExist(String message){
        super(message);
    }

}
