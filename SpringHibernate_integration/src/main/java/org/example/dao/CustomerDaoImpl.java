package org.example.dao;


import org.example.exception.CustomerNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.example.entity.customer;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;


@Component
public class CustomerDaoImpl implements CustomerDao {
    private SessionFactory sessionFactory;
    private Object Session;
    private static Scanner scanner=new Scanner(System.in);

    private Session session;
//    {
//        sessionFactory=new Configuration().configure("applicationContext.xml").addAnnotatedClass(customer.class).buildSessionFactory();
//    }

    public CustomerDaoImpl() {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        sessionFactory=context.getBean("sessionFactory",SessionFactory.class);

    }
    @Override

    public customer createCustomer(customer customer) {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(customer);
        session.getTransaction().commit();
        return customer;
    }

    public  List<customer> displayCustomer(){
       Session session=sessionFactory.openSession();
        Query query=session.createQuery("FROM customer");
        return query.getResultList();
    }

    public customer getCustomerById(int customerId) {
        Session=sessionFactory.openSession();
//        Customer customer=session.find(Customer.class,customerId);
        customer customer=session.find(customer.class,customerId);
        if(customer==null)
        {
            return null;
        }
        return customer;
    }

    public List<customer> getCustomerByName(String customerName) {

        session=sessionFactory.openSession();
        Query query=session.createQuery("FROM customer c where c.customer_name=?1");
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
    public customer updateCustomer(int customerId) {
        session=sessionFactory.openSession();
        customer customer=session.get(customer.class,customerId);
        if(customer==null)
        {
            throw new CustomerNotFoundException("no customer found.");
        }
        System.out.print("NAME: ");


        String name = scanner.next();
        customer.setCustomer_name(name);
        session.getTransaction().begin();
        session.merge(customer);
        session.getTransaction().commit();
        return customer;
    }


}
