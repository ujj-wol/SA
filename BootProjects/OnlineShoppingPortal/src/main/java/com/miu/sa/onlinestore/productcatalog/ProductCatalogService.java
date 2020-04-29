package com.miu.sa.onlinestore.productcatalog;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCatalogService {

    private final ProductRepository productRepository;

    public ProductCatalogService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> getProduct(String productNumber) {
        return productRepository.findById(productNumber);
    }

    public void setStock(String productNumber, Stock stock) {
        Optional<Product> currentProduct = getProduct(productNumber);
        currentProduct.ifPresent(product -> product.setStock(stock));
        productRepository.save(currentProduct.get());
    }
}