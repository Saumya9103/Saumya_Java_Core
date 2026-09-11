package Assignment2;

interface Shape {

    void displayShape();

    default void showMessage() {
        System.out.println("This is a shape");
    }

    static void staticMethod() {
        System.out.println("Static method from interface");
    }
}

class Square implements Shape {

    public void displayShape() {
        System.out.println("Shape: Square");
    }
}

class Triangle implements Shape {

    public void displayShape() {
        System.out.println("Shape: Triangle");
    }
}

public class Q17 {

    public static void main(String[] args) {

        Square square = new Square();
        Triangle triangle = new Triangle();

        square.displayShape();
        triangle.displayShape();

        square.showMessage();

        Shape.staticMethod();
    }
}