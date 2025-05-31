package com.chickentaki.order_service_be.controller;

import com.chickentaki.order_service_be.dto.CreateMenu;
import com.chickentaki.order_service_be.dto.MenuCreateRequest;
import com.chickentaki.order_service_be.dto.MenuInfo;
import com.chickentaki.order_service_be.model.Menu;
import com.chickentaki.order_service_be.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public List<MenuInfo> getMenu (@RequestParam(required = false) String category){
        System.out.println("Called get all menu API.");
        return menuService.getAllMenu(category);
    }

    @GetMapping("/menu/{id}")
    public MenuInfo getMenuById (@PathVariable String id){
        System.out.println("Called get all menu API.");
        return menuService.getMenuById(id);
    }

    @PostMapping("/menu")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMenu createMenu(@Valid @RequestBody MenuCreateRequest request) { // <-- CHANGED
        System.out.println("Invoke create manu api");
        return menuService.createMenu(request); // Pass the request DTO to service
    }

}
