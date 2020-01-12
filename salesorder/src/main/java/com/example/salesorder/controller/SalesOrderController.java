package com.example.salesorder.controller;

import com.example.salesorder.model.OrderDetails;
import com.example.salesorder.model.OrderWithLineItems;
import com.example.salesorder.model.SalesOrder;
import com.example.salesorder.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("salesOrderController")
public class SalesOrderController {
    private SalesOrderService salesOrderService;

    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @PostMapping(value = "/orders", produces = "application/json")
    public SalesOrder createOrder(@RequestBody OrderDetails orderDetails){
        return salesOrderService.createOrder(orderDetails);
    }
    @GetMapping(value = "getCustomerByEmail/{email}", produces = "application/json")
    public List<OrderWithLineItems> getCustomerByEmail(@PathVariable("email") String email) {
        return this.salesOrderService.getOrderIdByEmail(email);
    }





}
