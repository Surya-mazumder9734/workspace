package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustoemr(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> displayAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerByCustomerId(Integer id) {
        return customerRepository.findCustomerByCustomerId(id);
    }
}
