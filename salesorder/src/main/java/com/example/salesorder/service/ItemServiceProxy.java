package com.example.salesorder.service;


import com.example.salesorder.model.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="item-service")
@RibbonClient(name="item-service")
public interface ItemServiceProxy {

   @GetMapping(value="items/getItemByName/{name}", produces= "application/json")
   Item getItemByName(@PathVariable("name") String item);

}
