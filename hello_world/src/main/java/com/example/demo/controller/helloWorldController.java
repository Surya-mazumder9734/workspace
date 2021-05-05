package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
private Environment environment;

    public helloWorldController(Environment environment) {
        this.environment = environment;
    }
    @GetMapping("/")
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("Hello service is up at port number: "+environment.getProperty("local.server.port"));
    }
    @GetMapping(path = "/name?{name}")
    public String getname(@RequestParam("name") String name){
        return "hello world"+name;
    }
}
