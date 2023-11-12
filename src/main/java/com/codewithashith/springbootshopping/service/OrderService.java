package com.codewithashith.springbootshopping.service;

import com.codewithashith.springbootshopping.repository.CategoryRepository;
import com.codewithashith.springbootshopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
}
