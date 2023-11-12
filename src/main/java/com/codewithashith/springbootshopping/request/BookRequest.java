package com.codewithashith.springbootshopping.request;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Lob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private Long id;
    private Long categoryId;
    private String title;
    private String description;
    private String author;
    private Double price;
    private byte[] photo;
}
