public class ElectronicsOrder extends Order {
    private double itemPrice;
    private int warrantyMonths;

    public ElectronicsOrder(String orderId, String customerName, int orderDate, double itemPrice, int warrantyMonths) {
        super(orderId, customerName, orderDate);
        this.itemPrice = itemPrice;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateTotalPrice() {
        return itemPrice + (warrantyMonths * 50);
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics Order - ID: " + orderId + ", Customer: " + customerName
                + ", Date: " + orderDate + ", Price: " + calculateTotalPrice());
    }
}