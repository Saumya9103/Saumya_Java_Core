//10. Mini Project – Average and Grade
// Task:Write a program that:
// • Reads marks of 5 subjects into an array.
// • Calculates the average marks.
// • Uses if-else to assign grades: o >= 90: A o >= 75: B

package Assignment1;

import java.util.Scanner;

public class Q10 {
    public static void main (String [] args ) {
        Scanner sc = new Scanner (System.in);

        // Declare an array of size 5
        int[] marks = new int[5];

        int sum = 0;
        double average;

        // Input marks
        System.out.println("Enter the marks of 5 subjects: ");

        for (int i=0; i<5; i++) {
            System.out.print("Subject " + (i+1) + ":");
            marks[i] = sc.nextInt();

            // Add marks to sum
            sum += marks[i];
        }

        // calculate average
        average = (double)sum/5;

        //display average
        System.out.println("Average marks: " + average);

        // assign grade
        if (average>=90) {
            System.out.println("Grade: A");
        } else if (average>=75) {
            System.out.println("Grade: B");
        } else if (average>=50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Failed");
        }

        sc.close();
    }
}
