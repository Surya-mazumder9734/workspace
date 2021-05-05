package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HelloWorldResponse;

@RestController
public class HelloWorldController {

    //mime type
    @GetMapping(path = "/hello",produces = "application/json")
    public ResponseEntity<HelloWorldResponse> sayHello()
    {
        return ResponseEntity.status(HttpStatus.OK).body(new HelloWorldResponse("welcome to rest api"));
    }

}