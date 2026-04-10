package com.messenger.offerslistservice.Controller;

import com.messenger.offerslistservice.DAO.Entity.Buyer;
import com.messenger.offerslistservice.DAO.Repositories.BuyerRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductListController {

    private final BuyerRepository buyerRepository;

    public ProductListController(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }


    @PostMapping("/main")
    public String productlistpage(@AuthenticationPrincipal Jwt jwt) {

        System.out.println(jwt);
        String sub = jwt.getSubject();
        System.out.println(sub);

        if (!buyerRepository.existsBySub(sub)) {
            Buyer buyer = new Buyer();
            buyer.setSub(sub);
            buyerRepository.save(buyer);
            return "Пользователь сохранен:";
        } else {
            return "Пользователь уже есть в базе";
        }
    }


}





