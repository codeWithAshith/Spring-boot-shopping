package com.codewithashith.springbootshopping.response;

import com.codewithashith.springbootshopping.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserResponse {

    private AppUser appUser;

}
