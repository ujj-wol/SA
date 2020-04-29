package integration;

public class Order {
    private String orderNumber;
    private String amount;

    public Order(String orderNumber, String amount) {
        this.orderNumber = orderNumber;
        this.amount = amount;
    }

    public Order() {
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
