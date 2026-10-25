package Assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankDirectory {
    HashMap<Integer, String> accounts = new HashMap<>();

    void addAccount(int accountNo, String customerName) {
        if (accounts.containsKey(accountNo)) {
            System.out.println("Account number already exists.");
        } else {
            accounts.put(accountNo, customerName);
            System.out.println("Account added successfully.");
            System.out.println("Account No: " + accountNo
                    + " -> " + customerName);
        }
    }

    void getCustomer(int accountNo) {
        if (accounts.containsKey(accountNo)) {
            System.out.println("Customer Name: "
                    + accounts.get(accountNo));
        } else {
            System.out.println("Account not found.");
        }
    }

    void displayAll() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (Map.Entry<Integer, String> entry
                : accounts.entrySet()) {
            System.out.println("Account No: "
                    + entry.getKey() + " -> "
                    + entry.getValue());
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankDirectory bank = new BankDirectory();

        while (true) {
            System.out.println("\n1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int accountNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    bank.addAccount(accountNo, name);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int searchNo = sc.nextInt();

                    bank.getCustomer(searchNo);
                    break;

                case 3:
                    bank.displayAll();
                    break;

                case 4:
                    System.out.println("Exiting Bank Directory.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}