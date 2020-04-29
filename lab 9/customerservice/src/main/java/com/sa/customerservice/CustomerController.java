package com.sa.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    AccountFeignClient accountFeignClient;

    @RequestMapping("/customer/{customerId}")
    public String getName(@PathVariable String customerId) {
        return "From Customer Service: " + accountFeignClient.getNameCustom(customerId);
    }

    @FeignClient("MyAccountService")
    interface AccountFeignClient {
        @RequestMapping("/account/{customerId}")
        public String getNameCustom(@PathVariable String customerId);
    }

}
