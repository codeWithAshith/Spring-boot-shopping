package com.codewithashith.springbootshopping.repository;

import com.codewithashith.springbootshopping.model.AppUser;
import com.codewithashith.springbootshopping.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

    @Modifying
    @Query("update AppUser set role= :role where username = :username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);
}
