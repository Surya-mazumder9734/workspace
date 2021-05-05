package org.example.hibernate_demo;

import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.example.service.CustomerServiceImpl;

import java.util.List;
import java.util.Scanner;

public class App1 {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService;

    static {
        customerService = new CustomerServiceImpl();
    }


    public static void main(String[] args) {

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
                    customerService.createCustomer(new Customer(id, name));
                    System.out.print("customer created.");
                    break;
                case 2:
                    List<Customer> customer = customerService.getAllCustomer();
                    for (Customer e : customer) {
                        System.out.println(e);
                    }
                    break;


                case 3:
                    System.out.print("ID: ");
                    int id1 = scanner.nextInt();
                    Customer customer1=customerService.getCustomerById(id1);
                    System.out.println(customer1);
                    break;
                case 4:
                    System.out.print("Name: ");
                    String name1 = scanner.next();
                    List<Customer> customer2=customerService.getCustomerByName(name1);
                    System.out.println(customer2);
                    break;

                case 5:
                    System.out.print("ID: ");
                    int id3 = scanner.nextInt();
                    customerService.removeById(id3);


            }
        } while (choice != 0);


    }

}
