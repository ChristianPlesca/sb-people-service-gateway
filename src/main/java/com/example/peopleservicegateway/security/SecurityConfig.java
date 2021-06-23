package com.example.peopleservicegateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {

        http.authorizeExchange().pathMatchers("/actuator/health").permitAll();
        http.authorizeExchange().pathMatchers("/people-module/**").authenticated();
        http.oauth2ResourceServer().jwt();

        return http
                .csrf().disable()
                .build();
    }
}
