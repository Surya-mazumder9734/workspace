package com.example.demo.controller;

import com.example.demo.service.employeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
public class employeeController {
    private employeeService employeeService;

    @GetMapping(path = "/", produces = "application/json")
    public employeeService getEmployees()
    {

        return (com.example.demo.service.employeeService) employeeService.getEmployeeList();
    }
}
