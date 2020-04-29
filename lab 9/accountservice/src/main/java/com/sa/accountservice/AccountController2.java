package com.sa.accountservice;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("Two")
public class AccountController2 {

    @RequestMapping("/account/{customerId}")
    public String getName(@PathVariable String customerId) {
        return "Potato Doe";
    }
}
