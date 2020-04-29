package com.miu.sa.onlinestore.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(String orderId, ShoppingCart shoppingCart) {
        Order order = new Order(orderId);
        order.setShoppingCart(shoppingCart.getCartId());
        orderRepository.save(order);
    }

    public Order getOrder(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent())
            return order.get();
        return null;
    }
}
