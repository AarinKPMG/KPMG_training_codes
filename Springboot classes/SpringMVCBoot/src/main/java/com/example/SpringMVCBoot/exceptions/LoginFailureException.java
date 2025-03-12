package com.example.SpringMVCBoot.exceptions;

public class LoginFailureException extends Exception{

    public LoginFailureException(String message){
        super(message);
    }

}
