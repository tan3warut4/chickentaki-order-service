package com.chickentaki.order_service_be.dto;

import com.chickentaki.order_service_be.model.OrderStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderInfo(
        UUID id,
        String customerName,
        OrderStatus status,
        BigDecimal totalPrice) {}

