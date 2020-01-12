package com.example.salesorder.repository;

import com.example.salesorder.model.SalesOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {

    List<SalesOrder> findAllByEmail(String email);

}
