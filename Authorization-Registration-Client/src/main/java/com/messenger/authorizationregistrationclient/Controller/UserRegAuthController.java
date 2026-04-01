package com.messenger.authorizationregistrationclient.Controller;

import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserRegAuthController {

//    private final RestTemplate restTemplate;
//
//    public UserRegAuthController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//    @EventListener()
//    public ResponseEntity<?> login(@AuthenticationPrincipal OAuth2User principal) {
//        String sub = principal.getAttribute("sub");
//    try {
//    restTemplate.postForEntity("http://localhost:8081/main", sub, String.class);
//
//    return ResponseEntity.ok().build();
//    }
//    catch (Exception e) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }

    }












