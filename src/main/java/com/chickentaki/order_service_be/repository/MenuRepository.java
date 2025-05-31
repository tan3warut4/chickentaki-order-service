package com.chickentaki.order_service_be.repository;

import com.chickentaki.order_service_be.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
    List<Menu> findByCategory(String category);
}
