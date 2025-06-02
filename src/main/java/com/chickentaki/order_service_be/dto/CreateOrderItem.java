package com.chickentaki.order_service_be.dto;

public class CreateOrderItem {
    private MenuInfo menu;
    private int quantity;

    public CreateOrderItem(MenuInfo menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public MenuInfo getMenu() {
        return menu;
    }

    public void setMenu(MenuInfo menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

