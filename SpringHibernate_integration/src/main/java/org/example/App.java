package org.example;


import org.example.entity.customer;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App
{

    private CustomerService customerService;



    public App() {
        customerService=new CustomerServiceImpl();
    }



    public static void main(String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        App app=new App();
        int choice = 0;

        do {

            System.out.println("1.Create An Employee.");
            System.out.println("2.Display All Employees.");
            System.out.println("3.Find  Employees by ID");
            System.out.println("4.Find  Employees by Name");

            System.out.println("5.Delete  Employees by ID");
            System.out.println("6.Update  Employees by ID");


            System.out.println("0.Exit.");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("NAME: ");
                    String name = scanner.next();
                    //customerService.createCustomer(new Customer(id, name));
                    app.customerService.createCustomer(new customer(id,name));

                    System.out.print("customer created.");
                    break;
                case 2:
                    List<customer> c2=app.customerService.displayCustomer();
                       System.out.println(c2);
                  break;


                case 3:
                    System.out.print("ID: ");
                    int id1 = scanner.nextInt();
                    System.out.println(app.customerService.getCustomerById(id1));

                    break;
                case 4:

                    System.out.print("Name: ");
                    String name1 = scanner.next();
                    System.out.println(app.customerService.getCustomerByName(name1));
                    break;

                case 5:
                    System.out.print("ID: ");
                    int id3 = scanner.nextInt();
                    app.customerService.removeById(id3);
                case 6:
                    System.out.print("ID: ");
                    int id4 = scanner.nextInt();
                    app.customerService.updateCustomer(id4);


            }
        } while (choice != 0);
    }
}