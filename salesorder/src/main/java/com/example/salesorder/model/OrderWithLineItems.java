package com.example.salesorder.model;

import java.util.List;

public class OrderWithLineItems {
    SalesOrder salesOrder;
    List<OrderLineItem> orderLineItems;

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public List<OrderLineItem> getOrderWithLineItems() {
        return orderLineItems;
    }

    public void setOrderWithLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
}
