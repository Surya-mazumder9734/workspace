package com.example.orderservice.controller;

import com.example.orderservice.model.orderModel;
import com.example.orderservice.service.orderService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class orderController {
    private orderService orderService;

    private  Environment environment;

    public orderController(orderService order, Environment environment) {
        this.orderService = order;
        this.environment = environment;
    }
    @GetMapping("/api")
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("order service is up at port number: "+environment.getProperty("local.server.port"));
    }

    @PostMapping(path = "/orders")
    public ResponseEntity<orderModel> createCustomer(@RequestBody orderModel order)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
    }

    @GetMapping(path = "/orders/all")
    public ResponseEntity<List<orderModel>> displayOrder()
    {
        return ResponseEntity.ok(orderService.displayAllOrder());
    }
    @GetMapping(path= "/orders/{id}")
    public orderModel findById(@PathVariable("id") Integer id)
    {

        return orderService.findByOrderId(id);
    }


    @PutMapping(path = "/orders/update")
    public ResponseEntity<orderModel> updateOrder(@RequestBody orderModel model){
        orderModel order=orderService.updateOrder(model);
        return  new ResponseEntity<orderModel>(order,new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping(path = "/orders/delete/{id}")
    public HttpStatus deleteOrderById(@PathVariable("id") Integer id){
        orderService.deleteByOrderId(id);
        return HttpStatus.OK;
    }

}
