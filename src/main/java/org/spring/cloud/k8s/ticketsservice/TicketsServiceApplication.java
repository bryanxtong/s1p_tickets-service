package org.spring.cloud.k8s.ticketsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TicketsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketsServiceApplication.class, args);
    }

    @GetMapping(path = "/tickets")
    public int getAvailableTickets() {
        return 1010;
    }


    @Configuration
    @EnableWebSecurity
    public static class SecurityPermitAllConfig {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(authorizeHttpRequests ->
                            authorizeHttpRequests
                                    .anyRequest()
                                    .permitAll())
                    .csrf(AbstractHttpConfigurer::disable);
            return http.build();
        }
    }
}
