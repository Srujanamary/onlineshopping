package com.example.salesorder.repository;

import com.example.salesorder.model.OrderLineItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderLineItemRepository extends CrudRepository<OrderLineItem,Long> {

    List<OrderLineItem> getOrderLineItemByOrderId(Long id);
}
