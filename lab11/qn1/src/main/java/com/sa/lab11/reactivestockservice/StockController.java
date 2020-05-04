package com.sa.lab11.reactivestockservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StockController {

    @GetMapping("/stock")
    public Mono<Double> getStockPrice() {
        return Mono.just(StockValueGenerator.stockPrice);
    }
}
