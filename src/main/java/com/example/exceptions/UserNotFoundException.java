package com.example.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String account_not_found) {
        super(account_not_found);
    }
}
