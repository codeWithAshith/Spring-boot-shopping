package com.codewithashith.springbootshopping.controller.admin;

import com.codewithashith.springbootshopping.model.AppUser;
import com.codewithashith.springbootshopping.model.Role;
import com.codewithashith.springbootshopping.response.UserResponse;
import com.codewithashith.springbootshopping.response.common.APIResponse;
import com.codewithashith.springbootshopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RolesAllowed(Role.ADMIN)
public class AdminUserController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllUsers() {
        List<AppUser> appUsers = userService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(appUsers);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
