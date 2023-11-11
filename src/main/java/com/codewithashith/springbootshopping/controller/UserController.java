package com.codewithashith.springbootshopping.controller;

import com.codewithashith.springbootshopping.response.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('ROLE_USER')")
public class UserController {

    @Autowired
    private APIResponse apiResponse;

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUserDetails(@PathVariable Integer userId) {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createAddress() {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateAddress() {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteAddress(@PathVariable Integer id) {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
