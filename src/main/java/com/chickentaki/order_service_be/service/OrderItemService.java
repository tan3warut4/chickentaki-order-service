package com.chickentaki.order_service_be.service;

import com.chickentaki.order_service_be.dto.OrderItemInfo;
import com.chickentaki.order_service_be.model.OrderItem;
import com.chickentaki.order_service_be.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItemInfo> getItemsByOrder(UUID orderId) {
        List<OrderItem> items = orderItemRepository.findByOrderId(orderId);
        return items.stream().map(item -> new OrderItemInfo(
                item.getId(),
                item.getMenu().getName(),  // Extract menu name
                item.getQuantity(),
                item.getUnitPrice()
        )).collect(Collectors.toList());
    }
}
