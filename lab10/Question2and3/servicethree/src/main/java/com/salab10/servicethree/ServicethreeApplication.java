package com.salab10.servicethree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class ServicethreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicethreeApplication.class, args);
    }

}
