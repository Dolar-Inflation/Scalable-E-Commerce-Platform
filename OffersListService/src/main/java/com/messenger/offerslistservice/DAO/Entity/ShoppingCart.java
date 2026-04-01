package com.messenger.offerslistservice.DAO.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToMany
    private List<ProductList> productList;

}
