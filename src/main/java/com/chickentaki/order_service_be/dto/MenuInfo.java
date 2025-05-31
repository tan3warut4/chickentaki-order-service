// src/main/java/com.chickentaki.order_service_be.dto/MenuInfo.java
package com.chickentaki.order_service_be.dto;

import com.chickentaki.order_service_be.model.MenuCategory; // Import your enum
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

// This DTO will be used for displaying menu information
public class MenuInfo {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private MenuCategory category; // You can keep it as MenuCategory enum here directly for JSON conversion
    private String imageUrl;
    private boolean available;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    // --- Constructors ---
    public MenuInfo() {}

    // Constructor to easily map from Menu Entity to MenuInfo DTO
    public MenuInfo(UUID id, String name, String description, BigDecimal price, MenuCategory category, String imageUrl, boolean available, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
        this.available = available;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // --- Getters and Setters (auto-generate or use Lombok) ---
    // (Ensure you have all getters and setters for the fields above)
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public MenuCategory getCategory() { return category; }
    public void setCategory(MenuCategory category) { this.category = category; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}