package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getAllCustomers(){
        List<Customer> customers=new ArrayList<>();
        this.customerRepo.findAll().forEach(Customer -> customers.add(Customer));
        return customers;
    }

    public List<Customer> getCustomerByEmail(String email){
        return this.customerRepo.getCustomerByEmail(email);
    }
}
