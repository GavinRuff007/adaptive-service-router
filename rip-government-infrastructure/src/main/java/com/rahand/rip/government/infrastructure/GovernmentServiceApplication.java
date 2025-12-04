package com.rahand.rip.government.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rahand.rip")
public class GovernmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GovernmentServiceApplication.class, args);
    }
}
