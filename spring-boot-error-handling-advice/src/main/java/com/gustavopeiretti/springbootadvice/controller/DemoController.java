package com.gustavopeiretti.springbootadvice.controller;

import com.gustavopeiretti.springbootadvice.exception.CustomException;
import com.gustavopeiretti.springbootadvice.exception.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo-error")
    public String demo() {
        //Calling exception that produces an error
        throw new RuntimeException("Generic Runtime error");
    }

    @GetMapping("/demo-custom-error")
    public String demoCustomError() {
        //Calling exception that produces a custom error
        throw new CustomException("Custom exception error");
    }

    @GetMapping("/demo-custom-error-status")
    public String demoCustomErrorStatus() {
        //Calling exception that produces a custom error with ResponseStatus annotation
        throw new DataIntegrityViolationException("DataIntegrityViolationException exception error with ResponseStatus annotation");
    }

}
