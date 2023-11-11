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
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "product_purchased",
            joinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id",
                    referencedColumnName = "id"))
    private List<Book> books = new ArrayList<>();

    @ManyToOne
    private AppUser appUser;

    @CreationTimestamp
    private LocalDateTime purchaseTime;

    private Boolean deleteFlag = false;
}
