package com.example.demo.controller;

import com.example.demo.model.HelloWorldResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //mime controller
    @GetMapping(path = "/hello",produces = "application/json")
    public ResponseEntity<HelloWorldResponse> sayHello(){
        return ResponseEntity.status(HttpStatus.OK).body(new  HelloWorldResponse("welcome to rest api"));
    }

}
