package com.example.controller;

import com.example.model.employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping("/list")
    public String listEmployees(Model model){
    employee emp1=new employee(1,"levi","ackerman","lov2code.com");
    employee emp2=new employee(2,"Mikasa","ackerman","gegerc67.com");
//create list
        List<employee> theEmployee=new ArrayList<>();
        theEmployee.add(emp1);
        theEmployee.add(emp2);
        model.addAttribute("employees",theEmployee);
        return "list-employees";
    }
}
