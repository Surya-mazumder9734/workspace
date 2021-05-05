package com.example.orderservice.service;

import com.example.orderservice.model.orderModel;
import com.example.orderservice.repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class orderServiceimpl implements orderService{
    private OrderRepository orderRepository;

    public orderServiceimpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public orderModel createOrder(orderModel order) {
        return orderRepository.save(order);
    }

    @Override
    public List<orderModel> displayAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public orderModel findByOrderId(Integer id) {
        return orderRepository.findByOrderId(id);
    }

    @Override
    public orderModel updateOrder(orderModel orderModel) {
        Optional<orderModel> orderModel1=orderRepository.findById(orderModel.getOrderId());

        orderModel orderModel2=orderModel1.get();
        if (orderModel1.isPresent()){
            orderModel2.setOrderId(orderModel.getOrderId());
            orderModel2.setName(orderModel.getName());
            orderModel2.setPrice(orderModel.getPrice());
            orderRepository.save(orderModel2);
        }else{
            throw new NoSuchElementException("Not Found order");
        }

return orderModel2;
    }

    @Override
    public orderModel deleteByOrderId(Integer id) {
      return orderRepository.deleteByOrderId(id);
    }
}
