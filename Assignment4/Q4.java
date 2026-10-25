package Assignment4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    HashMap<Integer, Integer> products = new HashMap<>();

    void addProduct(int productId, int stock) {
        if (products.containsKey(productId)) {
            System.out.println("Product already exists.");
        } else if (stock < 0) {
            System.out.println("Stock cannot be negative.");
        } else {
            products.put(productId, stock);
            System.out.println("Product " + productId
                    + " added with stock " + stock);
        }
    }

    void updateStock(int productId, int stock) {
        if (!products.containsKey(productId)) {
            System.out.println("Product not found.");
        } else if (stock < 0) {
            System.out.println("Stock cannot be negative.");
        } else {
            products.put(productId, stock);
            System.out.println("Stock updated successfully.");
        }
    }

    void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        Iterator<Map.Entry<Integer, Integer>> iterator =
                products.entrySet().iterator();

        System.out.println("Product Inventory:");

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry =
                    iterator.next();

            System.out.println("Product ID: "
                    + entry.getKey()
                    + ", Stock: " + entry.getValue());
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Stock: ");
                    int stock = sc.nextInt();

                    inventory.addProduct(id, stock);
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Stock: ");
                    int newStock = sc.nextInt();

                    inventory.updateStock(updateId, newStock);
                    break;

                case 3:
                    inventory.displayInventory();
                    break;

                case 4:
                    System.out.println("Exiting Inventory System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}