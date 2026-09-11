//6. Loop – Multiplication Table Task:
// Ask the user for a number and print its multiplication table
// from 1 to 10 using a for loop.

package Assignment1;

import java.util.Scanner;

public class Q6 {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        //Multiplication Table
        System.out.println("Multiplication table of " + num + ":");

        for (int i=1; i<=10; i++) {
            System.out.println(num + "x" + i + "=" + (num*i));
        }

        sc.close();
    }
}
