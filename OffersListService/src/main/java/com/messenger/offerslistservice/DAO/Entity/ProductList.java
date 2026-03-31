package com.messenger.offerslistservice.DAO.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProductList {
    @Id
    private Long id;

    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private Long popularity;
}
