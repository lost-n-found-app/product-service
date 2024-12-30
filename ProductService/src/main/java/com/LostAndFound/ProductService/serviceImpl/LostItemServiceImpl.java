package com.LostAndFound.ProductService.serviceImpl;

import com.LostAndFound.ProductService.Entities.LostItem;
import com.LostAndFound.ProductService.exception.UserNotFoundException;
import com.LostAndFound.ProductService.repository.LostItemRepository;
import com.LostAndFound.ProductService.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LostItemServiceImpl implements LostItemService {

    @Autowired
    LostItemRepository lostItemRepository;

    @Override
    public LostItem saveLostItem(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

    @Override
    public Iterable<LostItem> getAllLostItems() {
        return lostItemRepository.findAll();
    }

    @Override
    public LostItem getLostItemById(int id) {
        return lostItemRepository.getById(id);
    }

//    @Override
//    public Optional<LostItem> getLostItemByName(String itemName) {
//        return lostItemRepository.findByName(itemName);
//    }

    public LostItem updateLostItem(int id, LostItem updatedItem) {
        Optional<LostItem> existingItemOptional = lostItemRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            LostItem existingItem = existingItemOptional.get();

            // Update fields
            existingItem.setItemName(updatedItem.getItemName());
            existingItem.setDescription(updatedItem.getDescription());
            existingItem.setPlace(updatedItem.getPlace());
            existingItem.setItem_lost(updatedItem.getItem_lost());
            existingItem.setDateTime(updatedItem.getDateTime());
            existingItem.setCity(updatedItem.getCity());
            existingItem.setPincode(updatedItem.getPincode());
            existingItem.setState(updatedItem.getState());
            existingItem.setStatus(updatedItem.getStatus());

            // Save updated entity
            return lostItemRepository.save(existingItem);
        } else {
            throw new UserNotFoundException(" this user is not found by ID"+id);
        }
    }

    // Method to delete LostItem by ID
    public void deleteLostItem(int id) {
        Optional<LostItem> existingItemOptional = lostItemRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            lostItemRepository.deleteById(id);  // Delete the item from the database
        } else {
            throw new UserNotFoundException(" this user is not found by ID"+id);
        }
    }
}
