package com.example.salesorder.service;

import com.example.salesorder.model.*;
import com.example.salesorder.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SalesOrderService {
    private SalesOrderRepository salesOrderRepository;
    private CustomerService customerService;
    private ItemService itemService;
    private OrderLineItemService orderLineItemService;

    public SalesOrderService(SalesOrderRepository salesOrderRepository, CustomerService customerService, ItemService itemService, OrderLineItemService orderLineItemService) {
        this.salesOrderRepository = salesOrderRepository;
        this.customerService = customerService;
        this.itemService = itemService;
        this.orderLineItemService = orderLineItemService;
    }

    public SalesOrder add(Date Date, String Email, String Description, Double Price) {

        System.out.println("----Inside the sales order service -----");
        System.out.println();
        SalesOrder salesOrder = new SalesOrder();

        salesOrder.setPrice(Price);
        salesOrder.setEmail(Email);
        salesOrder.setDescription(Description);
        salesOrder.setDate(Date);

        System.out.println("---salesOrder -----" + salesOrder);
        return this.salesOrderRepository.save(salesOrder);


    }

    public List<OrderWithLineItems> getOrderIdByEmail(String email)
    {
        List<SalesOrder> salesOrder = null;
        salesOrder = this.salesOrderRepository.findAllByEmail(email);
        List<OrderWithLineItems> orderWithLineItemsList = new ArrayList<>();
        for(SalesOrder salesOrder1 : salesOrder) {
            OrderWithLineItems orderWithLineItems = new OrderWithLineItems();

            orderWithLineItems.setSalesOrder(salesOrder1);
            orderWithLineItems.setOrderWithLineItems(this.orderLineItemService.getOrdersById(salesOrder1.getId()));
            orderWithLineItemsList.add(orderWithLineItems);
        }


        return orderWithLineItemsList;
    }


    public SalesOrder createOrder(OrderDetails orderDetails) {
        Customer customer;
        customer = customerService.getByEmail(orderDetails.getEmail());
        SalesOrder salesOrder = null;
        if(customer != null) {
            boolean itemExist=true;
            Double calculatedPrice = 0.0;
            for(String itemName: orderDetails.getItemNames()) {
                Item item = itemService.get(itemName);
                if(item==null){
                    itemExist=false;

                }else {
                    calculatedPrice += calculatedPrice +item.getPrice();
                }
                if (itemExist){
                    salesOrder = add(orderDetails.getDate(),orderDetails.getEmail(),orderDetails.getDescription(),calculatedPrice);
                    for(String itemName1: orderDetails.getItemNames()) {
                        Map<String,Integer> map = getQuantity(orderDetails);
                        orderLineItemService.add(itemName, salesOrder.getId(),map.get(itemName1));

                    }
                }

            }

        }

        return salesOrder;
    }

    private Map<String,Integer> getQuantity(OrderDetails orderDetails) {
        HashMap<String, Integer> hmap = new HashMap<>();
        for(String itemName1: orderDetails.getItemNames()) {
            if(hmap.containsKey(itemName1)) {
                int prev = hmap.get(itemName1);
                hmap.put(itemName1,prev++);
            } else {
                hmap.put(itemName1,1);
            }
        }

            return hmap;
    }
}
