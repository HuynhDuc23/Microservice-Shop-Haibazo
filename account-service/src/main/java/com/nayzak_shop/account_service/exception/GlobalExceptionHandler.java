package com.nayzak_shop.account_service.exception;

import java.util.HashMap;
import java.util.Map;

import com.nayzak_shop.account_service.dto.APICustomize;
import com.nayzak_shop.account_service.dto.ErrorResponse;
import com.nayzak_shop.account_service.enums.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<APICustomize<String>> handleUserExistException(UserExistException ex){
        //Xử lý lỗi khi đăng ký người dùng với username đã tồn tại
        APICustomize<String> response = new APICustomize<String>(ApiError.CONFLICT.getCode(), ex.getMessage(), "Fail Register");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ErrorLoginException.class)
    public ResponseEntity<APICustomize<String>> handleErrorLoginException(ErrorLoginException ex) {
        //Xử lý Login notFound with username and password
        APICustomize<String> response = new APICustomize<>(ApiError.BAD_REQUEST.getCode(), ex.getMessage(), "Fail Login");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<APICustomize<String>> handlePasswordNotMatchException(PasswordNotMatchException ex){
        //Xử lý mật khẩu không khớp khi đăng ký
        APICustomize<String> response = new APICustomize<>(ApiError.BAD_REQUEST.getCode(), ex.getMessage(), "Fail Register");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AccountNotExist.class)
    public ResponseEntity<APICustomize<String>> handleAccountNotExist(AccountNotExist ex){
        APICustomize<String> response = new APICustomize<>(ApiError.NOT_FOUND.getCode(),ex.getMessage(), "Fail Delete");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        //Xử lý các lỗi khác
        ErrorResponse errorResponse = new ErrorResponse(
                "An unexpected error occurred chung",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


}
