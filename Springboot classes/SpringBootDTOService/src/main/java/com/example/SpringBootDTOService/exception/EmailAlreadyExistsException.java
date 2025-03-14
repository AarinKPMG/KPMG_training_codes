package com.example.SpringBootDTOService.exception;

import jakarta.validation.constraints.Email;

public class EmailAlreadyExistsException extends RuntimeException{

    private String message;

    public EmailAlreadyExistsException(String message){super(message);}
}
