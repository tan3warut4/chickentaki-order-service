package com.chickentaki.order_service_be.service;

import com.chickentaki.order_service_be.dto.CreateOrder;
import com.chickentaki.order_service_be.dto.OrderInfo;
import com.chickentaki.order_service_be.dto.QrInfo;
import com.chickentaki.order_service_be.dto.UpdateOrder;
import com.chickentaki.order_service_be.model.Order;
import com.chickentaki.order_service_be.repository.OrderRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
        public CreateOrder createOrder(Order order){
        return null;
    }
    public UpdateOrder updateOrderStatus(String id){
        return null;
    }
    public OrderInfo getOrderStatus(String id){
        return null;
    }

    public QrInfo getQrPayment(String id){
        return null;
    }

}
