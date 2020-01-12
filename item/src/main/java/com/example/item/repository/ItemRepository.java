package com.example.item.repository;

import com.example.item.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item,Long> {
    List<Item> getItemByName(String name);


}
