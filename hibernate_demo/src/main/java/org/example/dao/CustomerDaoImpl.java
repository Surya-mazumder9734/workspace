package org.example.dao;
import org.example.Exception.CustomerNotFoundException;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao{
    private SessionFactory sessionFactory;
    private static Scanner scanner=new Scanner(System.in);

    private Session session;
    {
        sessionFactory=new Configuration().configure("hibernate1.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
    }
    @Override
    public void createCustomer(Customer customer) {

        try{
            session=sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(customer);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("duplicate id.");
        }


    }
    public List<Customer> getAllCustomer() {
        session=sessionFactory.openSession();
        Query query=session.createQuery("FROM Customer");
        return query.getResultList();
    }


    public Customer getCustomerById(int customerId) {
        session=sessionFactory.openSession();
//        Customer customer=session.find(Customer.class,customerId);
        Customer customer=session.find(Customer.class,customerId);

        if(customer==null)
        {
            return null;
        }
        return customer;
    }
    @Override
    public List<Customer> getCustomerByName(String customerName) {

            session=sessionFactory.openSession();
            Query query=session.createQuery("FROM Customer c where c.customerName=?1");
            query.setParameter(1,customerName);
            return query.getResultList();
        }


    public void removeById(int customerId) {
        session=sessionFactory.openSession();
//        Customer customer=session.find(Customer.class,customerId);
        session.delete(customerId);
        System.out.println("Succsfully deleted");
        session.getTransaction().begin();
        session.getTransaction().commit();

    }

    public Customer updateCustomer(int customerId) {
        session=sessionFactory.openSession();
        Customer customer=session.get(Customer.class,customerId);
        if(customer==null)
        {
            throw new CustomerNotFoundException("no customer found.");
        }
        System.out.print("NAME: ");

        String name = scanner.next();
        customer.setCustomerName(name);
        session.getTransaction().begin();
        session.merge(customer);
        session.getTransaction().commit();
        return customer;
    }
}

