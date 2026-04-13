package com.messenger.offerslistservice.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http


                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/","/main","/main.html","/api/me","/user-sync").permitAll()
//                        .requestMatchers("/api/me").authenticated()


                        .anyRequest().authenticated()
                )

                .oauth2ResourceServer(oath2 -> oath2.jwt((Customizer.withDefaults())));
        return http.build();

    }


}
