
package Assignment3;

import java.util.Random;
import java.util.Scanner;

// Thread to calculate the square of even numbers
class SquareCalculator extends Thread {
    private int number;

    SquareCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Square: " + (number * number));
    }
}

// Thread to calculate the cube of odd numbers
class CubeCalculator extends Thread {
    private int number;

    CubeCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Cube: " + (number * number * number));
    }
}

// Thread to generate random numbers
class RandomNumberGenerator extends Thread {

    public void run() {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(10) + 1;

            System.out.println("Generated: " + number);

            if (number % 2 == 0) {
                SquareCalculator square =
                        new SquareCalculator(number);
                square.start();

                try {
                    square.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            } else {
                CubeCalculator cube = new CubeCalculator(number);
                cube.start();

                try {
                    cube.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class Q9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Start Simulation");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                RandomNumberGenerator generator =
                        new RandomNumberGenerator();
                generator.start();

                try {
                    generator.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            } else if (choice == 2) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}

