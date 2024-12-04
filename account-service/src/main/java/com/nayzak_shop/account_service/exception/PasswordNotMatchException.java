package com.nayzak_shop.account_service.exception;

public class PasswordNotMatchException extends RuntimeException{

    public PasswordNotMatchException(String message){
        super(message);
    }

}
