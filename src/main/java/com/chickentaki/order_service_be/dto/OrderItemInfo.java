package com.chickentaki.order_service_be.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemInfo {
    private UUID id;
    private String menuName;
    private int quantity;
    private BigDecimal unitPrice;

    public OrderItemInfo(UUID id, String menuName, int quantity, BigDecimal unitPrice) {
        this.id = id;
        this.menuName = menuName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
