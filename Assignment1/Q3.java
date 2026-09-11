//3. Arithmetic Operations Task:
// Accept two integers from the user and perform addition, subtraction,
// multiplication, division, and modulus. Display results for each operation.

package Assignment1;

import java.util.Scanner;

public class Q3 {
    public static void main (String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner (System.in);

        //Accept two integers from the user
        System.out.println("Enter the first integer: ");
        int num1 = sc.nextInt();

        System.out.println("Enter the second integer: ");
        int num2 = sc.nextInt();

        //Perform Arithmetic Operations
        int addition = num1 + num2;
        int subtraction = num1 - num2;
        int multiplication = num1 * num2;
        int division = num1 / num2;
        int modulus = num1 % num2;

        //Display results
        System.out.println("\nResults:");
        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);
        System.out.println("Modulus: " + modulus);

        //Close Scanner
        sc.close();
    }
}
