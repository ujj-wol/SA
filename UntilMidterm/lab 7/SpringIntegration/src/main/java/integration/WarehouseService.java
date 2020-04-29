package integration;

import org.springframework.messaging.Message;

public class WarehouseService {
    public Order print(Order message) {
        System.out.println("At WarehouseService: " + message);
        return message;
    }
}
