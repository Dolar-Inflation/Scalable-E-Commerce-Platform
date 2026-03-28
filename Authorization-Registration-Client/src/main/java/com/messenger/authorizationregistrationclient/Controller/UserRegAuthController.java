package com.messenger.authorizationregistrationclient.Controller;

import com.messenger.authorizationregistrationclient.DTO.OAuth2UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegAuthController {

    @PostMapping("/login/oath2")
    public ResponseEntity<String> login(@AuthenticationPrincipal OAuth2User user) {

        OAuth2UserDTO oathdto = new OAuth2UserDTO();
        oathdto.setName(user.getName());
        System.out.println(oathdto);
        return ResponseEntity.ok(oathdto.toString());

    }







}
