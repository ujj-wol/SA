package com.salab10.servicetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class ServicetwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicetwoApplication.class, args);
    }

}
