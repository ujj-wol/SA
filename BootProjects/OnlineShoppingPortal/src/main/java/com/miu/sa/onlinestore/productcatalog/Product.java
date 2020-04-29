package com.miu.sa.onlinestore.productcatalog;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {
    @Id
    private String productNumber;
    private String description;
    private Double price;
    private Stock stock;

    public Product(String productNumber, String description, Double price) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
    }
}
