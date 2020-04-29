package com.miu.sa.onlinestore.shopping;

import com.miu.sa.onlinestore.productcatalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartLine {
    private Integer quantity;
    private Product product;
}
