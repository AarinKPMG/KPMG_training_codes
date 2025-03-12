package com.example.SpringMVCBoot.controller;

import com.example.SpringMVCBoot.exceptions.ApplicationException;
import com.example.SpringMVCBoot.exceptions.LoginFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("Login User Failed - login controller class");
        return "error";
    }

    @ExceptionHandler(LoginFailureException.class)
    public ResponseEntity handleLoginFailureException(LoginFailureException ex){
        System.out.println("Login User Failed - login controller class");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
}
