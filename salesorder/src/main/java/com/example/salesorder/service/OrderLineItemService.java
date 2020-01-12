package com.example.salesorder.service;

import com.example.salesorder.model.OrderLineItem;
import com.example.salesorder.repository.OrderLineItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderLineItemService {
    private OrderLineItemRepository orderLineItemsRepository;

    public OrderLineItemService(OrderLineItemRepository orderLineItemsRepository) {

        this.orderLineItemsRepository = orderLineItemsRepository;
    }

    // id, item_name, quantity, order_id
    public OrderLineItem add(String itemName, Long orderId, int quantity) {

        System.out.println("---Came inside the OrderLineItem --------");

        OrderLineItem orderLineItem = new OrderLineItem();

        orderLineItem.setItemName(itemName);
//        orderLineItem.setQuantity(quantity);
        orderLineItem.setQuantity(quantity);
        orderLineItem.setOrderId(orderId);


        return this.orderLineItemsRepository.save(orderLineItem);



    }

    public List<OrderLineItem>  getOrdersById(Long id)
    {
        HashMap<String, Integer> hmap = new HashMap<>();

        System.out.println("********** Entered orderLimeItemService *******************");

        List<OrderLineItem> orderListFromTable = this.orderLineItemsRepository.getOrderLineItemByOrderId(id);
        System.out.println(orderListFromTable);

        /*for (OrderLineItem order: orderListFromTable) {
            hmap.put(order.getItemName(),order.getQuantity());
        }
*/
        return orderListFromTable;
    }


}
