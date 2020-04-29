package com.salab10.servicetwo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerB {

    @RequestMapping("/serviceB/{test}")
    @HystrixCommand(fallbackMethod = "testFallback")
    public String test(@PathVariable String test) {
        return callServiceC(test + " fromB, ");
    }

    private String callServiceC(String test) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8083/serviceC/" + test, String.class);
    }

    public String testFallback(String text) {
        return "fallback response from B";
    }
}
