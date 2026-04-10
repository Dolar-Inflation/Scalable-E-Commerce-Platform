package com.messenger.authorizationregistrationclient.Configuration;

import com.messenger.authorizationregistrationclient.Services.Oath2EventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final Oath2EventHandler oath2EventHandler;

    public SecurityConfig(Oath2EventHandler oath2EventHandler) {
        this.oath2EventHandler = oath2EventHandler;
    }

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

                .oauth2Login(oauth-> oauth
//                        .defaultSuccessUrl("http://localhost:8081/main.html",true)
                        .successHandler(oath2EventHandler));




//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                );
        return http.build();







    }

}
