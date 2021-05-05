package com.example.demo.model;

public class employeeResponse {
    private String employeeName;
    private String location;
    private String email;

    public employeeResponse(String employeeName, String location, String email) {
        super();
        this.employeeName = employeeName;
        this.location = location;
        this.email = email;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "employeeResponse{" +
                "employeeName='" + employeeName + '\'' +
                ", age='" + location + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
