package com.chickentaki.order_service_be.dto;

import com.chickentaki.order_service_be.model.OrderStatus;

import java.util.List;
import java.util.UUID;

public class CreateOrder {
    private String customerName;
    private List<CreateOrderItem> items;

    public CreateOrder(String customerName, List<CreateOrderItem> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItems(List<CreateOrderItem> items) {
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<CreateOrderItem> getItems() {
        return items;
    }
}


