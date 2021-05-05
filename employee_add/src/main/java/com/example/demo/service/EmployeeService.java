package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Employee createEmployee(Employee employee);

    public Employee findById(int theId);

    public Employee delete(int id);
}