package com.messenger.authorizationregistrationclient.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class Oath2EventHandler implements AuthenticationSuccessHandler {

    private final RestTemplate restTemplate;


    public Oath2EventHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User principal = (OAuth2User) authentication.getPrincipal();
        assert principal != null;
        String sub = principal.getAttribute("sub");
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.convertValue(sub, JsonNode.class);
        String json = "\"" + sub + "\"";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(json,headers);

        try {
            restTemplate.postForEntity("http://localhost:8081/main",
                    entity,
                    String.class);
        }
        catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }

//        response.sendRedirect("http://localhost:8081/main");



    }




}
