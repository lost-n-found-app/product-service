package com.LostAndFound.ProductService.service;

import com.LostAndFound.ProductService.Entities.LostItem;

import java.util.Optional;

public interface LostItemService {

    public LostItem saveLostItem(LostItem lostItem);

    Iterable<LostItem> getAllLostItems();

    public LostItem getLostItemById(int id);

//    Optional<LostItem> getLostItemByName(String itemName);

    public LostItem updateLostItem(int id, LostItem updatedItem);

    public void deleteLostItem(int id);
}
