package com.mjc.school.service.Validator;

public class ValidationException extends RuntimeException{
    public ValidationException(String string){
        super(string);
    }
}
