import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();
    private LinkedList<String> history = new LinkedList<>();
    private final String autoSaveFile = "autosave.dat";

    public void addOrder(Order o) {
        orders.add(o);
        history.add("Added order: " + o.getOrderId());
        saveToFile(autoSaveFile);
    }

    public void removeOrder(String orderId) {
        boolean removed = orders.removeIf(o -> o.getOrderId().equals(orderId));
        if (removed) {
            history.add("Removed order: " + orderId);
            saveToFile(autoSaveFile);
        } else {
            System.out.println("Order ID not found.");
        }
    }

    public void displayAllOrders() {
        for (Order o : orders) {
            o.displayInfo();
        }
    }

    public void displayRevenueReport() {
        for (Order o : orders) {
            System.out.println("Order ID: " + o.getOrderId() + " - Total: " + o.calculateTotalPrice());
        }
    }

    public void displayTotalRevenueInPeriod(int startDate, int endDate) {
        double totalRevenue = 0;
        for (Order o : orders) {
            if (o.orderDate >= startDate && o.orderDate <= endDate) {
                totalRevenue += o.calculateTotalPrice();
            }
        }
        System.out.println("Total revenue from " + startDate + " to " + endDate + ": " + totalRevenue);
    }

    public void sortByOrderDate() {
        Collections.sort(orders);
    }

    public void sortByCustomerName() {
        orders.sort(new CustomerNameComparator());
    }

    public void sortByTotalPrice() {
        orders.sort(new TotalPriceComparator());
    }

    public void printHistory() {
        for (String record : history) {
            System.out.println(record);
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            orders = (ArrayList<Order>) ois.readObject();
            history.add("Loaded orders from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
