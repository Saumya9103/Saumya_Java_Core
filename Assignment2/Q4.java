package Assignment2;

class Calculator{

    public int add (int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public int add(int firstNumber, int secondNumber, int thirdNumber){
        return firstNumber + secondNumber + thirdNumber;
    }
}

public class Q4 {
    public static void main (String[] args) {

        Calculator calculator = new Calculator();

        int integerSum = calculator.add(3,4);

        double decimalSum = calculator.add(2.5,3.2);

        int threeNumberSum = calculator.add(4,5,6);

        System.out.println("Sum (int,int): " + integerSum);
        System.out.println("Sum (double,double): " + decimalSum);
        System.out.println("Sum (int,int,int): " + threeNumberSum);
    }
}
