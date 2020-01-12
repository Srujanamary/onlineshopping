package com.example.item.service;

import com.example.item.model.Item;
import com.example.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepo;

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        this.itemRepo.findAll().forEach(Item -> items.add(Item));
        return items;
    }
    public List<Item> getItemByName(String name) {
        return this.itemRepo.getItemByName(name);
    }
}




