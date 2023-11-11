package com.codewithashith.springbootshopping.dto;

import com.codewithashith.springbootshopping.model.AppUser;
import com.codewithashith.springbootshopping.request.RegisterRequest;
import com.codewithashith.springbootshopping.response.AuthResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthDto {

    public AppUser mapToAppUser(RegisterRequest registerRequest) {
        AppUser appUser = new AppUser();
        appUser.setUsername(registerRequest.getUsername());
        appUser.setName(registerRequest.getName());
        appUser.setPassword(registerRequest.getPassword());
        return appUser;
    }


    public AuthResponse mapToAuthResponse(AppUser appUser) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setId(appUser.getId());
        authResponse.setName(appUser.getName());
        authResponse.setUsername(appUser.getUsername());
        return authResponse;
    }
}
