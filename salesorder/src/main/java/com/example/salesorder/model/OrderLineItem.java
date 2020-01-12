package com.example.salesorder.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="OrderLineItem")
@Table(name="orderlineitem")

public class OrderLineItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String itemName;
    private int quantity;
    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
