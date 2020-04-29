package com.miu.sa.onlinestore.shopping;

import com.miu.sa.onlinestore.productcatalog.Product;
import com.miu.sa.onlinestore.productcatalog.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingService {

    private ShoppingCartRepository shoppingRepository;
    private ProductCatalogService productCatalogService;

    @Autowired
    private OrderService orderService;

    @Autowired
    public ShoppingService(ShoppingCartRepository shoppingRepository, ProductCatalogService productCatalogService) {
        this.shoppingRepository = shoppingRepository;
        this.productCatalogService = productCatalogService;
    }

    public Optional<ShoppingCart> getCart(String cartId) {
        return shoppingRepository.findById(cartId);
    }

    public void addToCart(String cartId, String productNumber, Integer quantity) {
        Optional<ShoppingCart> shoppingCart = getCart(cartId);
        Optional<Product> product = productCatalogService.getProduct(productNumber);
        CartLine cartLine = new CartLine(quantity, product.get());
        shoppingCart.get().addToCart(cartLine);
        shoppingRepository.save(shoppingCart.get());
    }

    public void createCart(ShoppingCart cart) {
        shoppingRepository.save(cart);
    }

    public void checkout(String cartId) {
    //TODO: implement the logic
        Optional<ShoppingCart> optionalCart = shoppingRepository.findById(cartId);
        //orderService.createOrder();

    }
}
