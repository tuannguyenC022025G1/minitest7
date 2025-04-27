public class FurnitureOrder extends Order {
    private double basePrice;

    public FurnitureOrder(String orderId, String customerName, int orderDate, double basePrice) {
        super(orderId, customerName, orderDate);
        this.basePrice = basePrice;
    }

    @Override
    public double calculateTotalPrice() {
        return basePrice + 200_000;
    }

    @Override
    public void displayInfo() {
        System.out.println("Furniture Order - ID: " + orderId + ", Customer: " + customerName
                + ", Date: " + orderDate + ", Price: " + calculateTotalPrice());
    }
}