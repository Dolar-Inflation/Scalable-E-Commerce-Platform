package com.messenger.offerslistservice.DAO.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sub;




}
