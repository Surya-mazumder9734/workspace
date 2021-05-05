
package org.example.service;

import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;
import org.example.entity.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;


    {
        customerDao=new CustomerDaoImpl();
    }
    @Override
    public void createCustomer(Customer customer) {
        customerDao.createCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);

    }

    @Override
    public List<Customer> getCustomerByName(String customerName) {
        return getCustomerByName(customerName);
    }

    @Override
    public void removeById(int customerId) {
        System.out.println("Deleted");
    }
}