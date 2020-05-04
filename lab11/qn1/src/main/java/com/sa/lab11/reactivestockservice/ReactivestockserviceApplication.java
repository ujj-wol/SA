package com.sa.lab11.reactivestockservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Duration;

@SpringBootApplication
@EnableScheduling
public class ReactivestockserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReactivestockserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        for(int i = 0; i++ < 5; ) {
//            Thread.sleep(2600);
//            System.out.println(StockValueGenerator.stockPrice);
//        }
    }
}
