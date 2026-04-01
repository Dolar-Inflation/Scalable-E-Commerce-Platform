package com.messenger.offerslistservice.Controller;

import com.messenger.offerslistservice.DAO.Entity.Buyer;
import com.messenger.offerslistservice.DAO.Repositories.BuyerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductListController {

    private final BuyerRepository buyerRepository;

    public ProductListController(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }


    @PostMapping("/main")
    public String productlistpage(@RequestBody String sub) {

        if (!buyerRepository.findBuyerBySub(sub)) {
            Buyer buyer = new Buyer();
            buyer.setSub(sub);
            buyerRepository.save(buyer);
            return "ok";
        } else {
            return "ok";
        }
    }




    }
