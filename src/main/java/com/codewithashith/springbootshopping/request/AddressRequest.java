package com.codewithashith.springbootshopping.request;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressRequest {
    private Long id;
    private Long userId;
    private String address;
    private String city;
    private Integer zipcode;
}
