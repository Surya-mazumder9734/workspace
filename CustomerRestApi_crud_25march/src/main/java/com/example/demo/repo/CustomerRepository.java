package com.example.demo.repo;

import com.example.demo.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Integer> {
    @Query
    public CustomerModel findByCustomerId(String customerId);
    @Query
    public CustomerModel findByEmail(String email);

    @Query
    public Integer deleteByCustomerId(String customerId);

    @Query
    public List<CustomerModel> findByFirstNameAndLastName(String firstName,String lastName);


}
