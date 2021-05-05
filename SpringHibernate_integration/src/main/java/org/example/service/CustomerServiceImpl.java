package org.example.service;

import org.example.dao.CustomerDao;
import org.example.dao.CustomerDaoImpl;
import org.example.entity.customer;

import java.util.List;


public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao;


    public CustomerServiceImpl() {
        customerDao=new CustomerDaoImpl();
    }


    @Override
    public customer createCustomer(customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public List<customer> displayCustomer() {
        return customerDao.displayCustomer() ;
    }

    @Override
    public customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public List<customer> getCustomerByName(String customerName) {
        return customerDao.getCustomerByName(customerName);
    }

    @Override
    public void removeById(int customerId) {
        return;
    }

    @Override
    public customer updateCustomer(int customerId) {
        return customerDao.updateCustomer(customerId);
    }
}
