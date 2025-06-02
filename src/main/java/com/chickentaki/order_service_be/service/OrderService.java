package com.chickentaki.order_service_be.service;

import com.chickentaki.order_service_be.dto.CreateOrder;
import com.chickentaki.order_service_be.dto.CreateOrderItem;
import com.chickentaki.order_service_be.dto.OrderInfo;
import com.chickentaki.order_service_be.dto.UpdateOrder;
import com.chickentaki.order_service_be.model.Menu;
import com.chickentaki.order_service_be.model.Order;
import com.chickentaki.order_service_be.model.OrderItem;
import com.chickentaki.order_service_be.model.OrderStatus;
import com.chickentaki.order_service_be.repository.MenuRepository;
import com.chickentaki.order_service_be.repository.OrderItemRepository;
import com.chickentaki.order_service_be.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository,
                        MenuRepository menuRepository,
                        OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public String createOrder(CreateOrder body) {
        // 1. Create Order
        Order order = new Order();
        order.setCustomerName(body.getCustomerName());
        order.setStatus(OrderStatus.ORDERED);
        order.setCreatedAt(OffsetDateTime.now());

        // 2. Calculate total and prepare OrderItems
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<OrderItem> orderItems = new ArrayList<>();

        for (CreateOrderItem dtoItem : body.getItems()) {
            System.out.println("DTO Menu ID: " + dtoItem.getMenu()); // Or use logger

            Menu menu = menuRepository.findById(dtoItem.getMenu().getId())
                    .orElseThrow(() -> new RuntimeException("Menu not found: " + dtoItem.getMenu().getId()));

            OrderItem item = new OrderItem();
            item.setOrder(order); // Set order relation
            item.setMenu(menu);
            item.setQuantity(dtoItem.getQuantity());
            item.setUnitPrice(menu.getPrice());

            BigDecimal itemTotal = menu.getPrice().multiply(BigDecimal.valueOf(dtoItem.getQuantity()));
            totalPrice = totalPrice.add(itemTotal);

            orderItems.add(item);
        }

        order.setTotalPrice(totalPrice);

        // 3. Save order, then items
        Order savedOrder = orderRepository.save(order);
        for (OrderItem item : orderItems) {
            item.setOrder(savedOrder); // update the saved order with ID
        }
        orderItemRepository.saveAll(orderItems);

        return "Successful Created Order";
    }
}
