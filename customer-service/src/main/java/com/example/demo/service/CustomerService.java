package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
public interface CustomerService {
    public Customer createCustoemr(Customer customer);

    public List<Customer> displayAllCustomer();

    public Customer findCustomerByCustomerId(Integer id);

}
