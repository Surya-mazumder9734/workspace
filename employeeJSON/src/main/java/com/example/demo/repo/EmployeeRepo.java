package com.example.demo.repo;

import com.example.demo.model.Employee;

import java.util.Collection;

public interface EmployeeRepo {
    public Collection<Employee> getAllEmployee();
    public Employee getEmployeeById(Integer id);
    public Collection<Employee> getEmployeeByName(String  name);
    public Employee createEmployee(Employee employee);
    public  Employee deleteEmployee(Integer id);
    public Employee updateEmployee(Employee employee,Integer id);

    }
