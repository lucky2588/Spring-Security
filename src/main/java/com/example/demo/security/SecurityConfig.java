package com.example.demo.security;

import jdk.jfr.Enabled;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/user").hasAnyRole("USER","ADMIN")
//                .requestMatchers("/admin").hasRole("ADMIN")
//                .requestMatchers("/author").hasRole("AUTHOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/",true)
                .and()
                .logout()
                .logoutSuccessUrl("/");

        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("111")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("111")
                .roles("ADMIN")
                .build();
        UserDetails author = User.withDefaultPasswordEncoder()
                .username("author")
                .password("111")
                .roles("AUTHOR")
                .build();
        UserDetails sale = User.withDefaultPasswordEncoder()
                .username("sale")
                .password("111")
                .roles("SALE")
                .build();

        return new InMemoryUserDetailsManager(user,admin,author,sale);
    }

}
