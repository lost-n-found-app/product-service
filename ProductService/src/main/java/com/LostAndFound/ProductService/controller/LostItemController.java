package com.LostAndFound.ProductService.controller;

import com.LostAndFound.ProductService.Entities.LostItem;
import com.LostAndFound.ProductService.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("LostItem")
public class LostItemController {

    @Autowired
    LostItemService lostItemService;


    //To save LostItem into DataBase
    @PostMapping
    public ResponseEntity<LostItem> saveLostItem(@RequestBody LostItem lostItem) {
        LostItem savedItem = lostItemService.saveLostItem(lostItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    //to GetAllLostItem list by DB
    @GetMapping
    public ResponseEntity<Iterable<LostItem>> getAllLostItems()
    {
        return ResponseEntity.ok(lostItemService.getAllLostItems());
    }

    //FetchLost Item by lostItem Id
    @GetMapping("/{id}")
    public ResponseEntity<LostItem> getLostItemById(@PathVariable int id)
    {
        return ResponseEntity.ok(lostItemService.getLostItemById(id));
    }

    //FetchLost Item by Item name
//    public LostItem getLostItemByName(@PathVariable String itemName)
//    {
//        return lostItemService.getLostItemByName(itemName)
//                .orElseThrow(() -> new RuntimeException("Item not found with name: " + itemName));
//
//    }

    //update Item by Id
    @PutMapping("/{id}")
    public LostItem updateLostItem(@PathVariable int id, @RequestBody LostItem updatedItem) {
        return lostItemService.updateLostItem(id, updatedItem);
    }

    //delete LostItem by id
    @DeleteMapping("/{id}")
    public void deleteLostItem(@PathVariable int id) {
        lostItemService.deleteLostItem(id);
    }
}
