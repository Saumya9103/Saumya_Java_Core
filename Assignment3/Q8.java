
package Assignment3;

import java.util.Scanner;

// PrinterJob implements Runnable
class PrinterJob implements Runnable {
    private int jobNumber;
    private String studentName;

    PrinterJob(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println("Printing job " + jobNumber
                + " by " + studentName);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Printing interrupted");
            Thread.currentThread().interrupt();
        }
    }
}

public class Q8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of print jobs: ");
        int n = sc.nextInt();

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            String studentName = "Student " + (char) ('A' + i);

            PrinterJob job = new PrinterJob(i + 1, studentName);
            threads[i] = new Thread(job);
            threads[i].start();
        }

        // Wait for all print jobs to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main thread interrupted");
                break;
            }
        }

        sc.close();
    }
}
