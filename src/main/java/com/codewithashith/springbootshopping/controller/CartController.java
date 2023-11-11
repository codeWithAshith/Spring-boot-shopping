package com.codewithashith.springbootshopping.controller;

import com.codewithashith.springbootshopping.response.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/cart")
public class CartController {

    @Autowired
    private APIResponse apiResponse;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllBooks() {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createBook() {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateBook() {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteBook(@PathVariable Integer id) {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
