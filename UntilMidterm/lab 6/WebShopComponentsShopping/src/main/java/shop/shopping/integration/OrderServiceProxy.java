package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import shop.shopping.service.ShoppingCartDTO;

@Service
public class OrderServiceProxy {

    @Autowired
    private RestOperations restTemplate;

    private final static String baseUrl = "http://localhost:80";

    public void createOrder(ShoppingCartDTO shoppingCartDTO) {
        restTemplate.postForLocation(baseUrl + "83/order", shoppingCartDTO);
    }
}
