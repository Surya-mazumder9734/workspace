package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepoImpl;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepoImpl = employeeRepo;
    }

    @Override
    public Collection<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeRepoImpl.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        // TODO Auto-generated method stub
        return employeeRepoImpl.getEmployeeById(id);
    }

    @Override
    public Collection<Employee> getEmployeeByName(String name) {
        return employeeRepoImpl.getEmployeeByName(name);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepoImpl.createEmployee(employee);
    }

    @Override
    public Employee deleteEmployee(Integer id) {
        return employeeRepoImpl.deleteEmployee(id);
    }

    @Override
    public Employee updateEmployee(Employee employee,Integer id) {
        return employeeRepoImpl.updateEmployee(employee,id);
    }

}
