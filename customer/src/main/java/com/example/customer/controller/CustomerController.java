package com.example.customer.controller;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

        @Autowired
        private CustomerService customerService;

        @GetMapping(value = "getAllCustomers", produces = "application/json")
        public List<Customer> getAll() {
            List<Customer> all = customerService.getAllCustomers();
            return all;
        }

        @GetMapping(value = "getCustomerByEmail/{email}", produces = "application/json")
        public List<Customer> getCustomerByEmail(@PathVariable("email") String email) {
            System.out.println("Entered Controller");
            return this.customerService.getCustomerByEmail(email);
        }
}
