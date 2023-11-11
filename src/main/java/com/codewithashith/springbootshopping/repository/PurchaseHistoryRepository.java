package com.codewithashith.springbootshopping.repository;

import com.codewithashith.springbootshopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<Order, Long> {

}
