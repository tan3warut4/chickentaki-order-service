package com.chickentaki.order_service_be.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class MenuCreateRequest {

    @NotBlank(message = "Menu name is required")
    @Size(max = 255, message = "Menu name cannot exceed 255 characters")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.00", inclusive = true, message = "Price must be non-negative")
    private BigDecimal price;

    @NotBlank(message = "Category is required")
    private String category; // Client sends enum as String, e.g., "FOOD"

    private String imageUrl;

    // --- Constructors, Getters, Setters (use your IDE to auto-generate or Lombok) ---
    public MenuCreateRequest() {}

    public MenuCreateRequest(String name, String description, BigDecimal price, String category, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}