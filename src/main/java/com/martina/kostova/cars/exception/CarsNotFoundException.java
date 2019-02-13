package com.martina.kostova.cars.exception;

public class CarsNotFoundException extends RuntimeException {

    public CarsNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
