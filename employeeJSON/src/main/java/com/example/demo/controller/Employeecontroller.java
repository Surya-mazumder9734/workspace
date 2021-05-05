package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class Employeecontroller {
    private EmployeeService employeeService;
    @Autowired
    public Employeecontroller(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees", produces = "application/json")
    public ResponseEntity<Collection<Employee>> findAllEmployee() {

        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
    }

    @GetMapping(path = "/employees/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }
    @GetMapping(path = "/employees/name/{firstName}")
    public ResponseEntity<Collection<Employee>> getEmployeeByName(@PathVariable("firstName") String name)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByName(name));
    }
    @PostMapping(path = "/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }
    @DeleteMapping(path = "/employees/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployee(id));
    }

    @PutMapping(path = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee)
    {
        Employee e=employeeService.updateEmployee(employee,id);
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }

}
