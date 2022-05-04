package com.github.mickeydeeluffy.chattyapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                     corsConfiguration.setAllowedOrigins(List.of("*"));
                     return corsConfiguration;

                })
                .and()
//                .csrf()
//                .disable()
                .oauth2ResourceServer()
                .jwt();

    }
}
