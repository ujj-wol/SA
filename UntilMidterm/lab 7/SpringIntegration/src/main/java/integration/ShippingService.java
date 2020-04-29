package integration;

import org.springframework.messaging.Message;

public class ShippingService {
    public String print(Order message) {
        System.out.println("At normal ShippingService: " + message);
        return "doneShipping";
    }
}
