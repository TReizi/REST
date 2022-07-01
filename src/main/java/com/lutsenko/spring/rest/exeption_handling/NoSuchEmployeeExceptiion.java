package com.lutsenko.spring.rest.exeption_handling;

public class NoSuchEmployeeExceptiion extends RuntimeException  {


    public NoSuchEmployeeExceptiion(String message) {
        super(message);
    }
}
