package org.example.service;

import org.example.entity.customer;

import java.util.List;

public interface CustomerService {
    public customer createCustomer(customer customer);
    public List<customer> displayCustomer();
    public customer getCustomerById(int customerId);
    public List<customer> getCustomerByName(String customerName);
    public void removeById(int customerId);
    public customer updateCustomer(int customerId);
}
