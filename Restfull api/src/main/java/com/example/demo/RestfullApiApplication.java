package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.sql.*;
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class RestfullApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestfullApiApplication.class, args);

    }

}
