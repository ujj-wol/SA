package com.miu.sa.onlinestore.productcatalog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {

    ProductCatalogService productService;

    public ProductCatalogController(ProductCatalogService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable String productNumber) {
        Product product = productService.getProduct(productNumber).orElse(null);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/update/{productNumber}")
    public void setStock(@PathVariable String productNumber, @RequestBody Product product) {
        productService.setStock(productNumber, product.getStock());
    }
}
