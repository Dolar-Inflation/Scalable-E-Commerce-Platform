package com.messenger.authorizationregistrationclient.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@Log4j2
@Service
public class Oath2EventHandler implements AuthenticationSuccessHandler {

    private final RestTemplate restTemplate;
    private final OAuth2AuthorizedClientService clientService;


    public Oath2EventHandler(RestTemplate restTemplate, OAuth2AuthorizedClientService clientService) {
        this.restTemplate = restTemplate;

        this.clientService = clientService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;

        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(),token.getName());
        assert client != null;
        String accessToken = client.getAccessToken().getTokenValue();

        ResponseCookie cookie = ResponseCookie.from("access_token", accessToken)
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .path("/")
                .maxAge(3600)
                .build();

        response.addHeader("Set-Cookie", cookie.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(client.getAccessToken().getTokenValue());
        HttpEntity<String> entity = new HttpEntity<>(null,headers);

        try {
            restTemplate.postForObject("http://localhost:8081/main",
                    entity,
                    String.class);

            response.sendRedirect("http://localhost:8081/");
        }
        catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }





    }

}
