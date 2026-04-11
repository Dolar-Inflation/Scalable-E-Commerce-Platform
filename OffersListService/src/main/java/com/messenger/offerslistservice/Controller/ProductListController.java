package com.messenger.offerslistservice.Controller;

import com.messenger.offerslistservice.DAO.Entity.Buyer;
import com.messenger.offerslistservice.DAO.Repositories.BuyerRepository;
import com.messenger.offerslistservice.Utility.GetUserNameBySub;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductListController {

    private final BuyerRepository buyerRepository;
    private final GetUserNameBySub getUserNameBySub;

    public ProductListController(BuyerRepository buyerRepository, GetUserNameBySub getUserNameBySub) {
        this.buyerRepository = buyerRepository;
        this.getUserNameBySub = getUserNameBySub;
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

    @GetMapping("/api/me")
    public Map<String, String> userInfo(@AuthenticationPrincipal Jwt jwt) {
        String name = getUserNameBySub.getUserName(jwt);



        return Map.of("name",name);

    }


}





