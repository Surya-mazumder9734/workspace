package com.example.demo;


import com.example.demo.model.employeeResponse;
import com.example.demo.repo.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private employeeRepository Repository;


    @Autowired
    public DemoApplication(employeeRepository Repository) {
        super();
        this.Repository = Repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Repository.save(new employeeResponse("John", "kolkata", "john@email.com"));
        Repository.save(new employeeResponse("Marry", "new york", "marry@email.com"));
        Repository.save(new employeeResponse("Sachin", "mumbai", "sachin@email.com"));
    }

}
