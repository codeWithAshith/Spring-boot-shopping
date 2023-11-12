package com.codewithashith.springbootshopping.response;

import com.codewithashith.springbootshopping.model.Address;
import com.codewithashith.springbootshopping.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
 public class BookResponse {

    private List<Book> bookList;
}
