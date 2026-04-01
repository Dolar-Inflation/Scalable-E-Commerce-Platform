package com.messenger.authorizationregistrationclient.Utility;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class UserUtility {

    @Bean
    public OAuth2UserService<OidcUserRequest, OidcUser> oauth2UserService() {
        var oidcUserService = new OidcUserService();

//        return userRequest -> {
//            var oidcUser = oidcUserService.loadUser(userRequest);

//            var authorities = Stream.concat(
//                    oidcUser.getAuthorities().stream(),
//                    roles.stream()
//                            .filter(role-> role.startsWith("ROLE_"))
//                            .map(SimpleGrantedAuthority::new)
//                            .map(GrantedAuthority.class::cast))
//                            .toList();
            return userRequest -> {
                var oidcUser = oidcUserService.loadUser(userRequest);

                    return new DefaultOidcUser(oidcUser.getAuthorities(), oidcUser.getIdToken(),oidcUser.getUserInfo());

        };

    }

}
