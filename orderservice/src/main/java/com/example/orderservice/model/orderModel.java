package com.example.orderservice.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class orderModel {
    @Id

    @Column(name = "item_id")
    private Integer orderId;
    @Column(name = "item_name")
    private String name;
    @Column(name = "price")
    private String price;
    public orderModel() {
        super();
    }

    public orderModel(Integer orderId, String name, String price) {
        this.orderId = orderId;
        this.name = name;
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}