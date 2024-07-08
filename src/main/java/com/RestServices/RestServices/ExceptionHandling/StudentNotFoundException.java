package com.RestServices.RestServices.ExceptionHandling;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String msg){
        super(msg);
    }
}
