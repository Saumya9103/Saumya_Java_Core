//9. Arrays and Loops – Find Maximum
// Task: Write a program to read 10 integers into an array
// and find the maximum value using a loop.

package Assignment1;

import java.util.Scanner;

public class Q9 {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);

        // Declare an array of size 10
        int[] numbers = new int[10];

        // Read 10 integers
        System.out.println("Enter 10 integers: ");
        for (int i=0; i<10; i++) {
            System.out.println("Number " + (i+1) + ":");
            numbers[i] = sc.nextInt();
        }

        // Assume the first element is maximum
        int max= numbers[0];

        // Find the maximum value
        for (int i=0; i<10; i++) {
            if (numbers[i] > max) {
                max=numbers[i];
            }
        }

        // Display the maximum value
        System.out.println("Maximum Value: " + max);

        sc.close();
    }
}
