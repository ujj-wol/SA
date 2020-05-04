package com.sa.lab11.reactivestockclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ReactivestockclientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReactivestockclientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=0; i++<5;) {
            Thread.sleep(2500);
            Mono<Double> stockPrice = WebClient.create("http://localhost:8080/stock")
                    .get()
                    .retrieve()
                    .bodyToMono(Double.class);

            stockPrice.subscribe(s -> System.out.println(s));
        }
    }
}
