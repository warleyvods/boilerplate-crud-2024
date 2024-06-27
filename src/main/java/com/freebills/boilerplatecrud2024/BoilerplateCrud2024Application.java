package com.freebills.boilerplatecrud2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
public class BoilerplateCrud2024Application {

    public static void main(String[] args) {
        SpringApplication.run(BoilerplateCrud2024Application.class, args);
    }
}
