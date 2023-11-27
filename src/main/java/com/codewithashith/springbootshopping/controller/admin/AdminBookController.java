package com.codewithashith.springbootshopping.controller.admin;

import com.codewithashith.springbootshopping.dto.BookDto;
import com.codewithashith.springbootshopping.model.Book;
import com.codewithashith.springbootshopping.model.Role;
import com.codewithashith.springbootshopping.repository.BookRepository;
import com.codewithashith.springbootshopping.request.BookRequest;
import com.codewithashith.springbootshopping.response.common.APIResponse;
import com.codewithashith.springbootshopping.service.BookService;
import com.codewithashith.springbootshopping.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/book")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RolesAllowed(Role.ADMIN)
public class AdminBookController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private BookService bookService;

    @GetMapping("/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
        Book book = bookService.getBook(name);
        return ResponseEntity
                .ok()
//                .contentType(MediaType.valueOf(book.getPhoto().getType()))
                .body(ImageUtils.decompressImage(book.getPhoto()));
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllBooks() {
        List<Book> bookList = bookService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createBook(
            @RequestParam("image") MultipartFile image,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("author") String author,
            @RequestParam("price") Double price
    ) throws IOException {

        System.out.println("Image: " + image.getOriginalFilename());
        System.out.println("Author: " + author);
        System.out.println("Category ID: " + categoryId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);

        Book book = new Book();
        book.setPrice(price);
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(author);
        book.setPhoto(image.getBytes());

        List<Book> bookList = bookService.createBook(book, categoryId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateBook(@RequestParam("image") MultipartFile file,
                                                  @RequestBody BookRequest bookRequest) {
        List<Book> bookList = bookService.updateBook(bookRequest, file);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteBook(@PathVariable Integer id) {
        List<Book> bookList = bookService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
