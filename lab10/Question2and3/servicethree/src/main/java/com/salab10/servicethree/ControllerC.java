package com.salab10.servicethree;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerC {

    @RequestMapping("/serviceC/{test}")
    public String test(@PathVariable String test) throws InterruptedException {
        Thread.sleep(5000);
        return test + " fromC !";
    }
}
