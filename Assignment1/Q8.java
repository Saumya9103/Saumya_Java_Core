//8. Arrays – Store and Print Marks Task: Write a program that:
// • Reads marks of 5 students into an integer array.
// • Prints each student’s marks.

package Assignment1;

import java.util.Scanner;

public class Q8 {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);

        //Declare an array of size 5
        int[] marks = new int[5];

        //Read marks
        System.out.println("Enter the marks of 5 student: ");
        for (int i=0; i<5; i++) {
            System.out.print("Student " + (i+1) + ":");
            marks[i]=sc.nextInt();
        }

        //Print marks
        System.out.println("\nMarks of the Students.");
        for (int i=0; i<5; i++) {
            System.out.println("Student" + (i+1) + ":" + marks[i]);
        }

        sc.close();
    }
}
