package com.codewithashith.springbootshopping.service;

import com.codewithashith.springbootshopping.dto.BookDto;
import com.codewithashith.springbootshopping.exception.common.ResourceNotFoundException;
import com.codewithashith.springbootshopping.model.Book;
import com.codewithashith.springbootshopping.model.Category;
import com.codewithashith.springbootshopping.repository.BookRepository;
import com.codewithashith.springbootshopping.repository.CategoryRepository;
import com.codewithashith.springbootshopping.request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDto bookDto;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public List<Book> createBook(BookRequest bookRequest) {
        Book book = bookDto.mapToBook(bookRequest);
        Category category = categoryRepository.findById(bookRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", bookRequest.getCategoryId()));
        book.setCategory(category);
        bookRepository.save(book);
        return findAll();
    }

    @Transactional
    public List<Book> updateBook(BookRequest bookRequest) {
        Book book = bookDto.mapToBook(bookRequest);
        Category category = categoryRepository.findById(bookRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", bookRequest.getCategoryId()));
        book.setCategory(category);
        bookRepository.save(book);
        return findAll();
    }

    public List<Book> deleteById(Integer id) {
        bookRepository.deleteById(Long.valueOf(id));
        return findAll();
    }
}
