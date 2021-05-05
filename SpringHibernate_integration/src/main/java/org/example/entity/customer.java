package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String customer_name;

    public customer() {
    }

    public customer(int customer_id, String customer_name) {
        this.customerId = customer_id;
        this.customer_name = customer_name;
    }

    public int getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(int customer_id) {
        this.customerId = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    @Override
    public String toString() {
        return "customer{" +
                "customer_id=" + customerId +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }

}

