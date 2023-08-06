package com.mjc.school.service;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String string){
        super(string);
    }
}
