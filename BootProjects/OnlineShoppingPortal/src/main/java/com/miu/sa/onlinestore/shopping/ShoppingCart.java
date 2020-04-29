package com.miu.sa.onlinestore.shopping;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class ShoppingCart {
    @Id
    private String cartId;
    private List<CartLine> cartLines = new ArrayList<>();

    public void addToCart(CartLine cartLine) {
        this.cartLines.add(cartLine);
    }

}
