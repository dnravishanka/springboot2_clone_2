package com.example.springboot2.adviser;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppAdviser {
    @ExceptionHandler({Exception.class})
    public String handleMyException(Exception exception) {
        return exception.getMessage();
    }
}
