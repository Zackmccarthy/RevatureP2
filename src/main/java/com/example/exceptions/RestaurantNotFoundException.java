package com.example.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String restaurant_does_not_exist) {
        super(restaurant_does_not_exist);
    }
}
