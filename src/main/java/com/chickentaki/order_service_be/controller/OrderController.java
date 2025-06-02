package com.chickentaki.order_service_be.controller;

import com.chickentaki.order_service_be.dto.*;
import com.chickentaki.order_service_be.model.Order;
import com.chickentaki.order_service_be.model.QrCode;
import com.chickentaki.order_service_be.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody CreateOrder body) {
        return orderService.createOrder(body);
    }

//    @GetMapping("/order-status/{id}")
//    public OrderInfo getOrderStatus(@PathVariable String id){
//        return  orderService.getOrderStatus(id);
//    }

//    @PutMapping("/order-status")
//    public UpdateOrder updateOrderStatus(String id){
//        return orderService.updateOrderStatus(id);
//    }


}
