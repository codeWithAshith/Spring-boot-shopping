package com.codewithashith.springbootshopping.repository;

import com.codewithashith.springbootshopping.model.Cart;
import com.codewithashith.springbootshopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
