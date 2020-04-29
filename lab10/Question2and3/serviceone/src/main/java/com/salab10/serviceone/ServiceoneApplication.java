package com.salab10.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class ServiceoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceoneApplication.class, args);
    }

}
