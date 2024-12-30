package com.LostAndFound.ProductService.repository;

import com.LostAndFound.ProductService.Entities.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LostItemRepository extends JpaRepository<LostItem,Integer> {

    // Custom method to find an item by name
   // Optional<LostItem> findByName(String itemName);
}
