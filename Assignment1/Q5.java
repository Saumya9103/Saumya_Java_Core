//5. Control Statement – Simple Calculator Task:
// Write a program that:
// • Takes two numbers and an operator symbol (+, -, *, /) from the user.
// • Uses if-else statements to perform the appropriate operation.

package Assignment1;

import java.util.Scanner;

public class Q5 {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);

        // User Input
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        System.out.print("Enter Operator (+,-,*,/): ");
        char operator = sc.next().charAt(0);

        // Perform calculations
        if (operator=='+') {
            System.out.println("Result = " + (num1+num2));
        } else if (operator=='-') {
            System.out.println("Result = " + (num1-num2));
        } else if (operator=='*') {
            System.out.println("Result = " + (num1*num2));
        } else if (operator=='/') {
            if (num2 != 0) {
                System.out.println("Result = " + (num1/num2));
            } else {
                System.out.println("Error: Division by zero is not allowed.");
            }
        } else {
            System.out.println("Invalid Operator");
        }
        sc.close();
    }
}
