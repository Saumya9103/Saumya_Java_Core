package Assignment1;

import java.util.Scanner;

public class TernaryVsIfElse {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);

        // User input
        System.out.println("Enter the student's marks: ");
        int marks = sc.nextInt();

        // Ternary Operator
        long startTernary = System.nanoTime();
        String ternaryResult = (marks>=40) ? "PASS":"FAIL";
        long endTernary = System.nanoTime();

        // If-Else
        long startIfElse = System.nanoTime();
        String ifElseResult;

        if (marks >= 40){
            ifElseResult = "PASS";
        } else {
            ifElseResult = "FAIL";
        }
        long endIfElse = System.nanoTime();


        // Display Results
        System.out.println("\nUsing Ternary Operator : " + ternaryResult);
        System.out.println("Using If-Else Statement : " + ifElseResult);

        System.out.println("\nExecution Time");
        System.out.println("Ternary : " + (endTernary - startTernary) + " ns");
        System.out.println("if-else : " + (endIfElse - startIfElse) + " ns");

        sc.close();
    }
}
