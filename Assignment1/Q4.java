//4. Logical Operators – Eligibility Check Task:
// Write a program to check if a person is eligible to vote.
// • Input: age and citizenship status (true or false).
// • Use logical operators (&&, ||) to decide eligibility.

package Assignment1;

import java.util.Scanner;

public class Q4 {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);

        // Input
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Is this person a citizen? (yes/no): ");
        String citizen = sc.next();

        boolean isCitizen = citizen.equalsIgnoreCase("yes");

        // Eligibility check
        if (age >= 18 && isCitizen) {
            System.out.println("Eligible to vote.");
        } else {
            System.out.println("Not eligible to vote.");
        }

        sc.close();
    }
}
