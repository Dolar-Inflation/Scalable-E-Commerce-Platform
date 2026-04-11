package com.messenger.offerslistservice.Utility;

import com.messenger.offerslistservice.DAO.Entity.Buyer;
import com.messenger.offerslistservice.DAO.Repositories.BuyerRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class GetUserNameBySub {

    private final BuyerRepository buyerRepository;

    public GetUserNameBySub(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }


    public String getUserName(@AuthenticationPrincipal Jwt jwt) {

//        var auth = SecurityContextHolder.getContext().getAuthentication();

        String username = jwt.getClaim("preferred_username");

        System.out.println(username);
        return username;

    }




}
