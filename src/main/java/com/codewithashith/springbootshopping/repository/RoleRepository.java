package com.codewithashith.springbootshopping.repository;

import com.codewithashith.springbootshopping.model.Book;
import com.codewithashith.springbootshopping.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
