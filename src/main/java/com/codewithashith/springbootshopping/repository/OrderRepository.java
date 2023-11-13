package com.codewithashith.springbootshopping.repository;

import com.codewithashith.springbootshopping.model.Cart;
import com.codewithashith.springbootshopping.model.Category;
import com.codewithashith.springbootshopping.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o inner join o.appUser a where a.id=?1")
    Optional<List<Order>> findUserOrder(Long userId);

}
