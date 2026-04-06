package com.messenger.offerslistservice.DAO.Repositories;

import com.messenger.offerslistservice.DAO.Entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    boolean existsBySub(String sub);
}

