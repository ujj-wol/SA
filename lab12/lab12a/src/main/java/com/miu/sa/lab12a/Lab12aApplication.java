package com.miu.sa.lab12a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Lab12aApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab12aApplication.class, args);
    }

    @GetMapping("/salary/{empId}")
    public String salary(@PathVariable String empId) {
        String salary = new RestTemplate().getForObject("localhost://8082/salary", String.class);
        return salary;
    }

    @GetMapping("/productData/{productId}")
    public String productData(@PathVariable String productId) {
        return productId + " : I am a mock product !";
    }

    @GetMapping("/employeeContact/{empId}")
    public String contactDetails(@PathVariable String empId) {
        String contact = new RestTemplate().getForObject("localhost://8081/contact/123", String.class);
        return contact;
    }


}
