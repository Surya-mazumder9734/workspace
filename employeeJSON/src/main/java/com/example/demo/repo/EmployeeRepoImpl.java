package com.example.demo.repo;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutorService;

@Component
public class EmployeeRepoImpl implements EmployeeRepo {


        Map<Integer, Employee> employeeMap;
    private Employee id;

    { Random random = new Random();
            employeeMap = new HashMap<Integer, Employee>();
            employeeMap.put(1,new Employee(1,"jhonyti","doehhh","jhoggggn@mail.com"));

            employeeMap.put(2,new Employee(random.nextInt(),"jhon","doe","jhon@mail.com"));
            employeeMap.put(3,new Employee(random.nextInt(), "jack","spparow","jack@mail.com"));
            employeeMap.put(4,new Employee(random.nextInt(), "rose","marlena","marlena@mail.com"));


        }

    @Override
    public Collection<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeMap.values();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        // TODO Auto-generated method stub
        Employee employee=employeeMap.get(id);
        if(employee==null)
        {
            throw new RuntimeException("no such id found");
        }
        return employee;
    }

    @Override
    public Collection<Employee> getEmployeeByName(String name) {
        Employee employee=employeeMap.get(name);
        if(employee==null)
        {
            throw new RuntimeException("no such name found");
        }
        return employeeMap.values();
    }
    @Override
    public Employee createEmployee(Employee employee) {
        // TODO Auto-generated method stub
        employeeMap.put(employeeMap.size()+1, employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(Integer id){

//        Employee employee=employeeMap.get(id);
        Employee tempEmployee=employeeMap.get(id);
        if(tempEmployee==null)
        {
            throw new EmployeeNotFoundException("no employee found with the given id: "+id);
        }
        if (tempEmployee.getEmployeeId().equals(id)){
            employeeMap.remove(id);
        }
        return  tempEmployee;

    }

    @Override
    public Employee updateEmployee(Employee employee,Integer id) {
        Employee tempEmployee=employeeMap.get(id);
        if(tempEmployee==null)
        {
            throw new EmployeeNotFoundException("no employee found with the given id: "+id);
        }
        tempEmployee.setFirstName(employee.getFirstName());
        tempEmployee.setLastName(employee.getLastName());
        tempEmployee.setEmail(employee.getEmail());
        employeeMap.remove(id);
        employeeMap.put(id, tempEmployee);
        return tempEmployee;
    }


}
