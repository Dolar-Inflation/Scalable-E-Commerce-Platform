package com.messenger.authorizationregistrationclient.Utility;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class JwtConverter {

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationToken() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtAuthenticationConverter.setPrincipalClaimName("preferred_username");
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter::convert);/*jwt-> {*/
//            var authorities = jwtGrantedAuthoritiesConverter.convert(jwt);
//
//
//            return Stream.concat(
//                    authorities.stream(),
//                    roles.stream()
//
//                            .filter(role->role.startsWith("ROLE_"))
//                            .map(SimpleGrantedAuthority::new)
//                            .map(GrantedAuthority.class::cast))
//                            .toList();
//
//        });
    return jwtAuthenticationConverter;
    }

}
