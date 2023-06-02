package com.example.demo;

import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.enums.Role;
import com.example.demo.services.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.example.demo.enums.Role.ADMIN;
import static com.example.demo.enums.Role.MANAGER;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("api/v1/admin/**").allowedOrigins("http://localhost:4200");

            }
        };
    }




}
