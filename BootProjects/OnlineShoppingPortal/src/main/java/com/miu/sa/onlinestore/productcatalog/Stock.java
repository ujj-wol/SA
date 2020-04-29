package com.miu.sa.onlinestore.productcatalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private Integer quantity;
    private String locationCode;
}
