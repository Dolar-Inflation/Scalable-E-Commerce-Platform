package com.messenger.offerslistservice.Controller;

import com.messenger.offerslistservice.Utility.GetUserNameBySub;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainPageController {

    private final GetUserNameBySub getUserNameBySub;


    public MainPageController(GetUserNameBySub getUserNameBySub) {
        this.getUserNameBySub = getUserNameBySub;

    }

    @GetMapping("/")
    public String mainPage(@AuthenticationPrincipal Jwt jwt) {



        return "redirect:/main.html";
    }




}
