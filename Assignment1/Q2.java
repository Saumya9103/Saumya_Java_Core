// 2. Data Type Conversion Task: Write a Java program that:
// • Stores an integer value for temperature in Celsius.
// • Converts it to Fahrenheit using the formula F = (C × 9/5) + 32.
// • Displays both Celsius and Fahrenheit values.

package Assignment1;

public class Q2 {
    public static void main(String [] args) {
        int celcius = 30;
        double fahrenheit = (celcius*9.0/5.0) + 32;

        System.out.println("Temperature in Celcius: " + celcius + "°C");
        System.out.println("Termperature in Fahrenheit: " + fahrenheit + "°F");
    }
}
