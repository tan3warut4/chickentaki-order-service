package com.chickentaki.order_service_be.dto;

import com.chickentaki.order_service_be.model.OrderStatus;

import java.util.UUID;

public record UpdateOrder(
        UUID id,
        OrderStatus status
) {}
