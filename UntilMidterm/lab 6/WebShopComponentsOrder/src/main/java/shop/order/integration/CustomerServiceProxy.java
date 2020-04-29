package shop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import shop.order.service.OrderCustomerDTO;

@Service
public class CustomerServiceProxy {

    @Autowired
    private RestOperations restTemplate;

    private final static String baseUrl = "http://localhost:80";

    public OrderCustomerDTO getOrderCustomer(String customerNumber) {
        return restTemplate.getForObject(baseUrl + "80/customer/" + customerNumber, OrderCustomerDTO.class);
    }
}
