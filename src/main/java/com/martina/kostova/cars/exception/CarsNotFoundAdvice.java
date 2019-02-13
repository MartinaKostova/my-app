package com.martina.kostova.cars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CarsNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CarsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CarsNotFoundAdvice(CarsNotFoundException ex) {
        return ex.getMessage();
    }
}
