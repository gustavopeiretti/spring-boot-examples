package com.gustavopeiretti.springbootadvice.advice;


import com.gustavopeiretti.springbootadvice.exception.CustomException;
import com.gustavopeiretti.springbootadvice.exception.CustomException2;
import com.gustavopeiretti.springbootadvice.exception.CustomException3;
import com.gustavopeiretti.springbootadvice.exception.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // Generic exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred - " + ex.getMessage());
    }

    // Custom exception handler
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("A custom error occurred - " + ex.getMessage());
    }

    @ExceptionHandler(value = {CustomException2.class, CustomException3.class})
    public ResponseEntity<String> handleSeveralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("A custom error occurred - " + ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public HttpEntity<String> handleSeveralExceptionWithResponseStatus(DataIntegrityViolationException ex) {
        return new HttpEntity<>("A error with ResponseStatus annotation");
    }

}
