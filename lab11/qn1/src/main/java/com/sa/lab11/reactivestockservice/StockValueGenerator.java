package com.sa.lab11.reactivestockservice;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StockValueGenerator {

    public static Double stockPrice;

    @Scheduled(fixedRate = 5000)
    public void getValue() {
        stockPrice = 50 + Math.random();
    }
}
