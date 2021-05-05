package com.example.demo.service;


import com.example.demo.model.employeeResponse;

import java.util.ArrayList;
import java.util.List;

// Class to store the list of
// all the employees in an
// Array List
public class employeeServiceImpl {

    private List<employeeResponse> employeeList;

    // Method to return the list
    // of employees
    public List<employeeResponse> getEmployeeList()
    {

        if (employeeList == null) {

            employeeList
                    = new ArrayList<>();


        }

        return employeeList;


    }

    public void
    setEmployeeList(
            List<employeeResponse> employeeList)
    {
        this.employeeList
                = employeeList;
    }

}
