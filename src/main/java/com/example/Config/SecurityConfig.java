package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
    /*@Bean
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
    }*/

    /*//CONFIGURATION other redireccionar
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        return httpSecurity
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers("/v1/index2").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin()
                .successHandler(successHandler())
                .permitAll()
                .and()
                .build();
    }

    public AuthenticationSuccessHandler successHandler()
    {
        return ((request, response, authentication) -> {
            response.sendRedirect("/v1/index");
        });
    }*/

    //CONFIGURATION the SESSION
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
    {
        return httpSecurity
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers("/v1/index2").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin()
                    .successHandler(successHandler())//URL redireccionar usuario, después de iniciar SESSION
                    .permitAll()
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)//Diferent Options: ALWAYS- If_REQUIRED - NEVER - STATELESS
                .invalidSessionUrl("/login")
                .maximumSessions(1)
                .expiredUrl("/login")
                .and()
                .build();
    }
    public AuthenticationSuccessHandler successHandler()
    {
        return ((request, response, authentication) -> {
            response.sendRedirect("/v1/index");
        });
    }

}
