package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


  /*  //CONFIGURATION ONE
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                    .requestMatchers("/v1/index2").permitAll()
                    .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .build();
        //CSRF Cross-Site Request Forgery
        //Nunca Desactiva para formularios
    }*/

    //CONFIGURATION TWO
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        return httpSecurity
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers("/v1/index2").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin().permitAll()
                .and()
                .build();
    }

}
