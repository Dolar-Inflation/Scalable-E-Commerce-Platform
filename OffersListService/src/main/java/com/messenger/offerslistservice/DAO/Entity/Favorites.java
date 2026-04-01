package com.messenger.offerslistservice.DAO.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "favorites")
@Entity
@Data
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Buyer buyer;

    @ManyToMany
    private List<ProductList> productList;
}
