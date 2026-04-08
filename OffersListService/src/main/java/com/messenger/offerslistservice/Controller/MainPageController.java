package com.messenger.offerslistservice.Controller;

import com.messenger.offerslistservice.Utility.GetUserNameBySub;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    private final GetUserNameBySub getUserNameBySub;

    public MainPageController(GetUserNameBySub getUserNameBySub) {
        this.getUserNameBySub = getUserNameBySub;
    }

    @GetMapping("/")
    public String mainPage(Authentication auth) {

        getUserNameBySub.getUserName();

        return "redirect:/main.html";
    }
}
