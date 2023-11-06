package com.codewithashith.springbootshopping.repository;

import com.codewithashith.springbootshopping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Book, Long> {
}
