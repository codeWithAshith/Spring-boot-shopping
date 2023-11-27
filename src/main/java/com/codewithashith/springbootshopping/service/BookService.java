package com.codewithashith.springbootshopping.service;

import com.codewithashith.springbootshopping.dto.BookDto;
import com.codewithashith.springbootshopping.exception.common.ResourceNotFoundException;
import com.codewithashith.springbootshopping.model.Book;
import com.codewithashith.springbootshopping.model.Category;
import com.codewithashith.springbootshopping.repository.BookRepository;
import com.codewithashith.springbootshopping.repository.CategoryRepository;
import com.codewithashith.springbootshopping.request.BookRequest;
import com.codewithashith.springbootshopping.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public List<Book> createBook(Book book, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", categoryId));
        book.setPhoto(ImageUtils.compressImage(book.getPhoto()));
        book.setCategory(category);
        bookRepository.save(book);
        return findAll();
    }

    @Transactional
    public List<Book> updateBook(BookRequest bookRequest, MultipartFile file) {
        Book book = bookDto.mapToBook(bookRequest);
        try {
            book.setPhoto(ImageUtils.compressImage(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public Book getBook(String name) {
        Optional<Book> bookOptional = bookRepository.findByTitle(name);
        return bookOptional.get();
    }
}
