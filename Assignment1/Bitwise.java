// Bitwise and Shift Operators
package Assignment1;

import java.util.Scanner;

public class Bitwise {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        // User Input
        System.out.println("Enter the first integer: ");
        int num1 = sc.nextInt();

        System.out.println("Enter the second integer: ");
        int num2 = sc.nextInt();

        System.out.println("Enter number of positions to shift: ");
        int shift = sc.nextInt();

        // --------------------------------------------------------
        // BITWISE OPERATORS
        // --------------------------------------------------------

        // Bitwise AND
        System.out.println("\nBitwise AND (&): " + (num1 & num2));

        // Bitwise OR
        System.out.println("Bitwise OR (|): " + (num1 | num2));

        // Bitwise XOR
        System.out.println("Bitwise XOR (^): " + (num1 ^ num2));

        // Bitwise NOT (Unary)
        System.out.println("Bitwise NOT (~) of first number: " + (~num1));
        System.out.println("Bitwise NOT (~) of first number: " + (~num2));

        // -------------------------------------------------------
        // SHIFT OPERATORS
        // -------------------------------------------------------

        // Left Shift
        System.out.println("\nLeft Shift (<<): " + (num1 << num2));

        // Right Shift
        System.out.println("\nRight Shift (>>): " + (num1 >> num2));

        sc.close();
    }
}
