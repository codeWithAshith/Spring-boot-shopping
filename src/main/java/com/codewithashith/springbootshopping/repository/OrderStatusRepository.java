package com.codewithashith.springbootshopping.repository;

import com.codewithashith.springbootshopping.model.Order;
import com.codewithashith.springbootshopping.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

}
