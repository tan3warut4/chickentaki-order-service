package com.chickentaki.order_service_be.service;

import com.chickentaki.order_service_be.dto.CreateMenu;
import com.chickentaki.order_service_be.dto.MenuCreateRequest;
import com.chickentaki.order_service_be.dto.MenuInfo;
import com.chickentaki.order_service_be.model.Menu;
import com.chickentaki.order_service_be.model.MenuCategory;
import com.chickentaki.order_service_be.repository.MenuRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors; // For stream operations

import java.util.List;
import java.util.UUID;
@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }
    public List<MenuInfo> getAllMenu(String category) {
        List<Menu> menus;
        if(category!=null && !category.isEmpty()){
            menus = menuRepository.findByCategory(category);
        }else{
           menus = menuRepository.findAll();
        }
        System.out.println("Menus from DB: " + menus);
        // 2. Use Java Streams to map each Menu entity to a MenuInfo DTO
        return menus.stream()
                .map(menu -> new MenuInfo(
                        menu.getId(),
                        menu.getName(),
                        menu.getDescription(),
                        menu.getPrice(),
                        menu.getCategory(), // Directly pass the enum, Jackson handles conversion to string in JSON
                        menu.getImageUrl(),
                        menu.getAvailable(),
                        menu.getCreatedAt(),
                        menu.getUpdatedAt()
                ))
                .collect(Collectors.toList()); // 3. Collect them into a List
    }
    public CreateMenu createMenu(MenuCreateRequest request) { // <-- CHANGED PARAMETER TYPE
        // 1. Convert DTO to Entity
        Menu menu = new Menu();
        menu.setName(request.getName());
        menu.setDescription(request.getDescription());
        menu.setPrice(request.getPrice());
        // Handle category conversion (String from DTO to MenuCategory enum)
        try {
            menu.setCategory(MenuCategory.valueOf(request.getCategory().toUpperCase()));
        } catch (IllegalArgumentException e) {
            // Handle invalid category string (e.g., throw a custom exception, or return HTTP 400)
            throw new IllegalArgumentException("Invalid menu category: " + request.getCategory());
        }
        menu.setImageUrl(request.getImageUrl());
        menu.setAvailable(true); // Set default for new menu items

        // createdAt and updatedAt are handled by @PrePersist in Menu entity,
        // but can be explicitly set here if not using lifecycle callbacks.
        // menu.setCreatedAt(OffsetDateTime.now());
        // menu.setUpdatedAt(OffsetDateTime.now());

        // 2. Save the Entity to the database
        Menu savedMenu = menuRepository.save(menu);

        // 3. Convert the saved Entity to the CreateMenu response DTO
        return new CreateMenu(savedMenu.getId(), savedMenu.getName());
    }
    // --- Implement getMenuById() as well (as it's in your controller) ---
    public MenuInfo getMenuById(String idString) { // Changed param to String to match controller
        UUID id = UUID.fromString(idString); // Convert String ID from path to UUID
        return menuRepository.findById(id)
                .map(menu -> new MenuInfo( // Map found entity to DTO
                        menu.getId(),
                        menu.getName(),
                        menu.getDescription(),
                        menu.getPrice(),
                        menu.getCategory(),
                        menu.getImageUrl(),
                        menu.getAvailable(),
                        menu.getCreatedAt(),
                        menu.getUpdatedAt()
                ))
                .orElseThrow(() -> new RuntimeException("Menu not found with ID: " + idString)); // Handle not found
    }
}
