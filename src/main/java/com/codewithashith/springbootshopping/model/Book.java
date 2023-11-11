package com.codewithashith.springbootshopping.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false, length = 200)
    private String author;

    @Column(nullable = false, length = 200)
    private Double price;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(mappedBy = "books")
    private List<Cart> carts = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Boolean deleteFlag = false;
}
