package com.example.service;
import java.sql.SQLException;
import java.util.List;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.*;
public interface EmployeeService {
	public List<Employee> getAllEmployees() throws SQLException;
	public void removeEmployeeById(int id) throws SQLException, EmployeeNotFoundException;
	public Employee updateEmployees(Employee employee,int id)throws SQLException,EmployeeNotFoundException;



	}
