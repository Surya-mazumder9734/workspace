package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.core.env.Environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
	private CustomerService customerService;
	private Environment environment;
	@Autowired
	public CustomerController(CustomerService customerService, Environment environment) {
		super();
		this.customerService = customerService;
		this.environment = environment;
	}

	@GetMapping("/")
	public ResponseEntity<String> getStatus()
	{
        return ResponseEntity.ok("customer service is up at port number: "+environment.getProperty("local.server.port"));
	}
    @PostMapping(path = "/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustoemr(customer));
    }

    @GetMapping(path = "/customers")
    public ResponseEntity<List<Customer>> displayCustomers()
    {
        return ResponseEntity.ok(customerService.displayAllCustomer());
    }
    @GetMapping(path= "/customers/{id}")
    public Customer findById(@PathVariable("id") Integer id)
    {
        return customerService.findCustomerByCustomerId(id);
    }

}