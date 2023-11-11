package com.codewithashith.springbootshopping.controller.admin;

import com.codewithashith.springbootshopping.response.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/user")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminUserController {

    @Autowired
    private APIResponse apiResponse;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllUsers() {

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
