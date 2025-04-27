public class ClothingOrder extends Order {
    private double basePrice;
    private String size;

    public ClothingOrder(String orderId, String customerName, int orderDate, double basePrice, String size) {
        super(orderId, customerName, orderDate);
        this.basePrice = basePrice;
        this.size = size;
    }

    @Override
    public double calculateTotalPrice() {
        if (size.equalsIgnoreCase("L") || size.equalsIgnoreCase("XL")) {
            return basePrice * 1.1;
        }
        return basePrice;
    }

    @Override
    public void displayInfo() {
        System.out.println("Clothing Order - ID: " + orderId + ", Customer: " + customerName
                + ", Date: " + orderDate + ", Price: " + calculateTotalPrice());
    }
}