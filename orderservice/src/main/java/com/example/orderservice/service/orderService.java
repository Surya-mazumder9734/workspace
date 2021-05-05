package com.example.orderservice.service;

import com.example.orderservice.model.orderModel;

import java.util.List;

public interface orderService {
    public orderModel createOrder(orderModel order);

    public List<orderModel> displayAllOrder();

    public orderModel findByOrderId(Integer id);

    public  orderModel updateOrder(orderModel orderModel);

    public orderModel deleteByOrderId(Integer id);

}
