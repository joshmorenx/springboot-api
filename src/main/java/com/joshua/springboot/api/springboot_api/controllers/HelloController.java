package com.joshua.springboot.api.springboot_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@ControllerAdvice

public class HelloController {
    @GetMapping("/app/foo")
    public Map<String, String> foo() {

        Map<String, String> json = new HashMap<>();
        json.put("message", "Hello World API Spring Boot");

        return json;
    }
    @GetMapping("/")
    public Map<String, String> bar() {

        Map<String, String> json = new HashMap<>();
        json.put("message", "main page Spring Boot");

        return json;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Ruta no encontrada");
        error.put("error", ex.getMessage());
        return error;
    }
}
