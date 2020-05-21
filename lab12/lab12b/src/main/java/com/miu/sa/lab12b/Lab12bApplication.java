package com.miu.sa.lab12b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Lab12bApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab12bApplication.class, args);
    }

    @GetMapping("/contact/{empId}")
    public String getContact(@PathVariable String empId) {
        if(empId.equals("111"))
            return "1234";
        return "5678";
    }


}
