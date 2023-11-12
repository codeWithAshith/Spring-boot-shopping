package com.codewithashith.springbootshopping.dto;

import com.codewithashith.springbootshopping.model.Address;
import com.codewithashith.springbootshopping.model.Book;
import com.codewithashith.springbootshopping.request.AddressRequest;
import com.codewithashith.springbootshopping.request.BookRequest;
import com.codewithashith.springbootshopping.response.AddressResponse;
import com.codewithashith.springbootshopping.response.BookResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDto {

    public BookResponse mapToBookResponse(List<Book> bookList) {
        return new BookResponse(bookList);
    }

    public Book mapToBook(BookRequest bookRequest) {
        Book book = new Book();
        if (bookRequest.getId() != null) {
            book.setId(bookRequest.getId());
        }
        book.setAuthor(bookRequest.getAuthor());
        book.setPrice(bookRequest.getPrice());
        book.setDescription(bookRequest.getDescription());
        book.setTitle(bookRequest.getTitle());
        book.setPhoto(bookRequest.getPhoto());
        return book;
    }
}
