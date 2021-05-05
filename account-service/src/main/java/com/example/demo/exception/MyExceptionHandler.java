package com.example.demo.exception;

import com.example.demo.shared.ErrorResponse;
import org.apache.tomcat.jni.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException e){
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.getErrorReportTime(System.currentTimeMillis());
        response.getStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAnyException(Exception e){
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.getErrorReportTime(System.currentTimeMillis());
        response.getStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }
}
