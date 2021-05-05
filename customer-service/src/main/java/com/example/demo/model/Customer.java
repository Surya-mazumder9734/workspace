package com.example.demo.model;

import javax.persistence.*;
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "address")
    private String address;
    public Customer() {
        super();
    }
    public Customer(Integer customerId, String name, String address) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}