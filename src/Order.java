import java.io.Serializable;

public abstract class Order implements Payable, Comparable<Order>, Serializable {
    protected String orderId;
    protected String customerName;
    protected int orderDate; // yyyyMMdd

    public Order(String orderId, String customerName, int orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public abstract void displayInfo();

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.orderDate, o.orderDate);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }
}
