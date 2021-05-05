package com.example.demo.repo;
import com.example.demo.model.employeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<employeeResponse, Integer> {

}