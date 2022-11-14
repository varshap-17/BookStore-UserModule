package com.example.usermodule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class UserModuleApplication {

    public static void main(String[] args) {
        log.info("User-Module is running..");
        SpringApplication.run(UserModuleApplication.class, args);
    }
}
