package com.codewithashith.springbootshopping.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String status;

    @OneToOne(mappedBy = "orderStatus")
    private Order order;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Boolean deleteFlag = false;
}
