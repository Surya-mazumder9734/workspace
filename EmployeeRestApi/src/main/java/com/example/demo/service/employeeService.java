package com.example.demo.service;

import com.example.demo.model.employeeResponse;

import java.util.List;

public interface employeeService {
    public List<employeeResponse> getEmployeeList();
    public void setEmployeeList(List<employeeResponse> employeeList);

}
