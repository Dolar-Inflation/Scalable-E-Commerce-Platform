package com.messenger.authorizationregistrationclient.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.requestMatchers("/login","/register").permitAll()
                        .requestMatchers("/error").permitAll()
                        .anyRequest().authenticated()


        )

                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
                                .jwt(Customizer.withDefaults())
                        )

//                .oauth2Login(oauth2Login -> oauth2Login
//                                .loginPage("/login")
//                        )

                .oauth2Login(Customizer.withDefaults());

//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                );
        return http.build();







    }

}
