package integration;

public class NextDayShippingService {
    public String print(Order message) {
        System.out.println("At nextDay ShippingService: " + message);
        return "doneNextDayShipping";
    }
}
