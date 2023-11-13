package com.codewithashith.springbootshopping.response;

import com.codewithashith.springbootshopping.model.Address;
import com.codewithashith.springbootshopping.model.OrderedBook;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long id;
    private List<OrderedBook> bookList;
    private Long userId;
    private String name;
    private String username;
    private Address address;
    private String orderStatus;
}
