package com.codewithashith.springbootshopping.repository;

import com.codewithashith.springbootshopping.model.Book;
import com.codewithashith.springbootshopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
