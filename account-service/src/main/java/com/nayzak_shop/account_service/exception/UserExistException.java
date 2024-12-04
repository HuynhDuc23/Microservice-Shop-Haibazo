package com.nayzak_shop.account_service.exception;

public class UserExistException extends RuntimeException{

    public UserExistException(String message) {
        super(message);
    }

}
