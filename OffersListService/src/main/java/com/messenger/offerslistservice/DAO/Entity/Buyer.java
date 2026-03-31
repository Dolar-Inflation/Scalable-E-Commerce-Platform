package com.messenger.offerslistservice.DAO.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Buyer {
    @Id
    private Long id;
    private String sub;




}
