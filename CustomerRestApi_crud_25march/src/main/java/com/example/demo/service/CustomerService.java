package com.example.demo.service;

import com.example.demo.dto.CustomerDto;

public interface CustomerService {
    public CustomerDto createCustomer(CustomerDto customerDto);
    public CustomerDto findByCustomerId(String customerId);
    public CustomerDto findByEmail(String email);
    public Integer deleteByCustomerId(String customerId);
    public CustomerDto updateCustomer(String customerId,CustomerDto customerDto);

}
