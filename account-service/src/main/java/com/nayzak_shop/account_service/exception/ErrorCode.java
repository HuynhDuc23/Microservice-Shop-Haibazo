package com.nayzak_shop.account_service.exception;

public enum ErrorCode {

    HTTP_REQUEST_ENDPOINT_SUPPORT("9999", "BAD ENDPOINT");

    private String code = "9999";
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
