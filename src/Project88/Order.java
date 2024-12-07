package Project88;

public class Order {
    private int orderId;
    private String description;
    private Status status;

    public Order(int orderId, String description, Status status) {
        this.orderId = orderId;
        this.description = description;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
