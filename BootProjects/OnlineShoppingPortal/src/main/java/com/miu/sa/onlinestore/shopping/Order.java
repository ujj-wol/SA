package com.miu.sa.onlinestore.shopping;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
    private String orderId;
    private String shoppingCart;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(String shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
