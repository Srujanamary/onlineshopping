package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> getCustomerByEmail(String email);
}
