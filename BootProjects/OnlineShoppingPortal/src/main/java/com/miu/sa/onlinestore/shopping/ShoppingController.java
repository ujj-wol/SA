package com.miu.sa.onlinestore.shopping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    private ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/cart/{cartId}")
    public ResponseEntity<?> getCart(@PathVariable String cartId) {
        ShoppingCart shoppingCart = shoppingService.getCart(cartId).get();
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }

    @PutMapping("/cart/{cartId}/{productNumber}/{quantity}")
    public void addToCart(@PathVariable String cartId, @PathVariable String productNumber, @PathVariable Integer quantity) {
        shoppingService.addToCart(cartId, productNumber, quantity);
    }

    @PostMapping("/cart")
    public void createCart(@RequestBody ShoppingCart cart) {
        shoppingService.createCart(cart);
    }


}
