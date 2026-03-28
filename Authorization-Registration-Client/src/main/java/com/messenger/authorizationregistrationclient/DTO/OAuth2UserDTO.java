package com.messenger.authorizationregistrationclient.DTO;

import lombok.Data;

@Data
public class OAuth2UserDTO {
    String provider;
    String providerId;
    String email;
    String name;
    String avatarUrl;
}

