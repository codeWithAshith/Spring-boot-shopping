package com.codewithashith.springbootshopping.service;

import com.codewithashith.springbootshopping.repository.BookRepository;
import com.codewithashith.springbootshopping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
}
