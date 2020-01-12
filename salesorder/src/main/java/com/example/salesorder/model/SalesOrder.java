package com.example.salesorder.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Objects;

@Entity(name="SalesOrder")
@Table(name="salesorder")
@Data
public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String description;
    private Date date;
    @Email
    private String email;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}