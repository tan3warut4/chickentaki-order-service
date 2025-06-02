package com.chickentaki.order_service_be.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "orders") // Maps to the 'orders' table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Assuming you want DB to generate UUID
    private UUID id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "total_price")
    private BigDecimal totalPrice; // Using BigDecimal for NUMERIC(10,2)

    @Enumerated(EnumType.STRING) // Tells JPA to store the enum as its String name in the DB
//    @Column(nullable = false)
    private OrderStatus status; // Your Java enum for order status

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at") // Good practice to have updated_at
    private OffsetDateTime updatedAt;

    // One-to-Many mapping with OrderItem
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    // --- Constructors ---
    // JPA requires a no-argument constructor
    public Order() {
    }

    // Optional: All-arguments constructor for convenience
    public Order(UUID id, String customerName, BigDecimal totalPrice, OrderStatus status, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // --- Getters and Setters ---
    // (Auto-generate these with your IDE: Alt+Insert or right-click -> Generate...)
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    @PrePersist // JPA lifecycle callback: sets createdAt and updatedAt before persisting
    protected void onCreate() {
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now(); // Also set updated_at on creation
    }

    @PreUpdate // JPA lifecycle callback: updates updatedAt before updating
    protected void onUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }
}