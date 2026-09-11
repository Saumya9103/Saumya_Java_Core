//7. Loop with Conditional – Sum of Even Numbers Task:
// Write a program that uses a while
// loop to find the sum of all even numbers between 1 and 50.

package Assignment1;

public class Q7 {
    public static void main (String [] args) {

        int i = 1;
        int sum = 0;

        // while loop
        while (i<=50) {
            // check if the number is evem
            if (i%2==0){
                sum+=i;
            }

            i++;
        }

        System.out.println("Sum of all even numbers between 1 and 50 = " + sum);
    }
}
