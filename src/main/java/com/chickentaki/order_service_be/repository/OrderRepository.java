package com.chickentaki.order_service_be.repository;

import com.chickentaki.order_service_be.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
