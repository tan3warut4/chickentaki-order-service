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
    public CreateOrder createOrder(Order order){
        return orderService.createOrder(order);
    }

    @GetMapping("/order-status/{id}")
    public OrderInfo getOrderStatus(@PathVariable String id){
        return  orderService.getOrderStatus(id);
    }

    @PutMapping("/order-status")
    public UpdateOrder updateOrderStatus(String id){
        return orderService.updateOrderStatus(id);
    }
    @PostMapping("/qr-code/{id}")
   public QrInfo getQrPayment(@PathVariable String id){
        return orderService.getQrPayment(id);
    }

}
