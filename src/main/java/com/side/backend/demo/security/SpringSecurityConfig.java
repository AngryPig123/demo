package com.side.backend.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig {

//    @Bean
    public SecurityFilterChain appSecurity(HttpSecurity http) throws Exception {
        http.
                authorizeRequests(authorize -> {
                    authorize.antMatchers("/css/**").permitAll();
                })
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin();

        return http.build();
    }

}