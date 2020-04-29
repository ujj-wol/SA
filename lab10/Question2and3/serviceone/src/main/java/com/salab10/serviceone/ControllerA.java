package com.salab10.serviceone;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerA {

    @RequestMapping("/serviceA/{test}")
    @HystrixCommand(fallbackMethod = "testFallback")
    public String test(@PathVariable String test) {
        return callServiceB(test + " fromA, ") + ": DONE !!";
    }

    private String callServiceB(String test) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8082/serviceB/" + test, String.class);
    }

    public String testFallback(String text) {
        return "fallback response from A";
    }
}
