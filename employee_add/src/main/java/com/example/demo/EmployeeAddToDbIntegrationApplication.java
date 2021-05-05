package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeAddToDbIntegrationApplication implements CommandLineRunner {

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeAddToDbIntegrationApplication(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeAddToDbIntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        employeeRepository.save(new Employee("John", "Doe", "john@email.com"));
        employeeRepository.save(new Employee("Marry", "Public", "marry@email.com"));
        employeeRepository.save(new Employee("Sachin", "Tendulkar", "sachin@email.com"));
    }

}