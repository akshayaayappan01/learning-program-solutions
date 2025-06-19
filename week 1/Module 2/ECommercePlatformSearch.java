import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Product class
class Product {
    int id;
    String name;
    String category;
    double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-20s | Category: %-15s | Price: $%.2f", id, name, category, price);
    }
}

// Main class
public class ECommercePlatformSearch {

    // Method to load sample product data
    private static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 750.00));
        products.add(new Product(2, "Smartphone", "Electronics", 500.00));
        products.add(new Product(3, "Running Shoes", "Footwear", 120.00));
        products.add(new Product(4, "Bluetooth Speaker", "Electronics", 80.00));
        products.add(new Product(5, "Wrist Watch", "Accessories", 250.00));
        products.add(new Product(6, "Backpack", "Bags", 45.00));
        products.add(new Product(7, "LED TV", "Electronics", 999.99));
        products.add(new Product(8, "Formal Shoes", "Footwear", 160.00));
        return products;
    }

    // Search by product name
    private static void searchByName(List<Product> products, String query) {
        System.out.println("\n🔍 Results for name containing: '" + query + "'");
        boolean found = false;
        for (Product product : products) {
            if (product.name.toLowerCase().contains(query.toLowerCase())) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found with that name.");
        }
    }

    // Search by category
    private static void searchByCategory(List<Product> products, String query) {
        System.out.println("\n🔍 Results for category: '" + query + "'");
        boolean found = false;
        for (Product product : products) {
            if (product.category.equalsIgnoreCase(query)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in that category.");
        }
    }

    // Search by price range
    private static void searchByPriceRange(List<Product> products, double min, double max) {
        System.out.println("\n🔍 Results for price range: $" + min + " - $" + max);
        boolean found = false;
        for (Product product : products) {
            if (product.price >= min && product.price <= max) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in this price range.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> catalog = loadProducts();

        System.out.println("=== Welcome to E-Commerce Platform Search ===");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose Search Option:");
            System.out.println("1. Search by Product Name");
            System.out.println("2. Search by Category");
            System.out.println("3. Search by Price Range");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter product name to search: ");
                    String nameQuery = scanner.nextLine();
                    searchByName(catalog, nameQuery);
                    break;
                case 2:
                    System.out.print("Enter category to search (e.g., Electronics, Footwear): ");
                    String categoryQuery = scanner.nextLine();
                    searchByCategory(catalog, categoryQuery);
                    break;
                case 3:
                    try {
                        System.out.print("Enter minimum price: $");
                        double minPrice = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter maximum price: $");
                        double maxPrice = Double.parseDouble(scanner.nextLine());
                        searchByPriceRange(catalog, minPrice, maxPrice);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price! Please enter valid numeric values.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the E-Commerce Search. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please select a number from 1 to 4.");
            }
        }

        scanner.close();
    }
}
