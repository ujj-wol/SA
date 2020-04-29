package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import shop.shopping.service.ProductDTO;

@Service
public class ProductCatalogServiceProxy {

    @Autowired
    private RestOperations restTemplate;

    private final static String baseUrl = "http://localhost:80";

    public ProductDTO getProduct(String productnumber) {
        return restTemplate.getForObject(baseUrl + "81/product/" + productnumber, ProductDTO.class);
    }
}
