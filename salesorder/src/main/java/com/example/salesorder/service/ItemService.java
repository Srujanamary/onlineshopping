package com.example.salesorder.service;


import com.example.salesorder.model.Item;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemServiceProxy itemServiceProxy;

    public ItemService(ItemServiceProxy itemServiceProxy) {
        this.itemServiceProxy = itemServiceProxy;
    }

    @HystrixCommand(fallbackMethod = "defaultItemService")
    public Item get(String item) {
        return this.itemServiceProxy.getItemByName(item);
    }

    private Item defaultItemService(String item){
        System.out.println("The item is not available or the service is down");
        Item itemModel=new Item();

        itemModel.setId(-1L);
        itemModel.setName(item);

        return itemModel;
    }
}
