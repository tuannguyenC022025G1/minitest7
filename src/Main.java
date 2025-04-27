import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderManager manager = new OrderManager();
        int choice;

        do {
            System.out.println("------ MENU ------");
            System.out.println("1. Add new Order (Electronics / Clothing / Furniture)");
            System.out.println("2. Remove Order by ID");
            System.out.println("3. Display all Orders");
            System.out.println("4. Display Revenue Report");
            System.out.println("5. Sort by Order Date");
            System.out.println("6. Sort by Customer Name");
            System.out.println("7. Sort by Total Price");
            System.out.println("8. Show History");
            System.out.println("9. Save Orders to File");
            System.out.println("10. Load Orders from File");
            System.out.println("11. Display Total Revenue in Date Range");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Order Type (1- Electronics, 2- Clothing, 3- Furniture): ");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.print("Order ID: ");
                    String orderId = sc.nextLine();
                    System.out.print("Customer Name: ");
                    String customerName = sc.nextLine();
                    System.out.print("Order Date (yyyyMMdd): ");
                    int orderDate = Integer.parseInt(sc.nextLine());

                    if (type == 1) {
                        System.out.print("Item Price: ");
                        double itemPrice = Double.parseDouble(sc.nextLine());
                        System.out.print("Warranty Months: ");
                        int warranty = Integer.parseInt(sc.nextLine());
                        manager.addOrder(new ElectronicsOrder(orderId, customerName, orderDate, itemPrice, warranty));
                    } else if (type == 2) {
                        System.out.print("Base Price: ");
                        double basePrice = Double.parseDouble(sc.nextLine());
                        System.out.print("Size: ");
                        String size = sc.nextLine();
                        manager.addOrder(new ClothingOrder(orderId, customerName, orderDate, basePrice, size));
                    } else if (type == 3) {
                        System.out.print("Base Price: ");
                        double basePrice = Double.parseDouble(sc.nextLine());
                        manager.addOrder(new FurnitureOrder(orderId, customerName, orderDate, basePrice));
                    } else {
                        System.out.println("Invalid type!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Order ID to remove: ");
                    String removeId = sc.nextLine();
                    manager.removeOrder(removeId);
                    break;

                case 3:
                    manager.displayAllOrders();
                    break;

                case 4:
                    manager.displayRevenueReport();
                    break;

                case 5:
                    manager.sortByOrderDate();
                    System.out.println("Sorted by Order Date.");
                    break;

                case 6:
                    manager.sortByCustomerName();
                    System.out.println("Sorted by Customer Name.");
                    break;

                case 7:
                    manager.sortByTotalPrice();
                    System.out.println("Sorted by Total Price.");
                    break;

                case 8:
                    manager.printHistory();
                    break;

                case 9:
                    System.out.print("Enter filename to save: ");
                    String saveFile = sc.nextLine();
                    manager.saveToFile(saveFile);
                    break;

                case 10:
                    System.out.print("Enter filename to load: ");
                    String loadFile = sc.nextLine();
                    manager.loadFromFile(loadFile);
                    break;

                case 11:
                    System.out.print("Enter start date (yyyyMMdd): ");
                    int start = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter end date (yyyyMMdd): ");
                    int end = Integer.parseInt(sc.nextLine());
                    manager.displayTotalRevenueInPeriod(start, end);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
