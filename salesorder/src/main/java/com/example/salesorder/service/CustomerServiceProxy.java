package com.example.salesorder.service;


import com.example.salesorder.model.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RibbonClient(name="customer-service")
@FeignClient(name="customer-service")
public interface CustomerServiceProxy {
    @GetMapping("customers/getCustomerByEmail/{email}")
    Customer getCustomerByEmail(@PathVariable("email") String email);

}
