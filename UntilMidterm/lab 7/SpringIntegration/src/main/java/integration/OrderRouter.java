package integration;

public class OrderRouter {
    public String route(Order order) {
        if(Double.parseDouble(order.getAmount()) > 175)
            return "nextDayChannel";

        return "normalChannel";
    }
}
