package Assignment2;

abstract class Shapes {

    abstract void area();

    abstract void perimeter();
}

class Circle extends Shapes {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Circle Area: " + result);
    }

    void perimeter() {
        double result = 2 * Math.PI * radius;
        System.out.println("Circle Perimeter: " + result);
    }
}

class Rectangle extends Shapes {

    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    void area() {
        double result = length * width;
        System.out.println("Rectangle Area: " + result);
    }

    void perimeter() {
        double result = 2 * (length + width);
        System.out.println("Rectangle Perimeter: " + result);
    }
}

public class Q3 {

    public static void main(String[] args) {

        Circle c = new Circle(5);

        c.area();
        c.perimeter();

        Rectangle r = new Rectangle(4, 6);

        r.area();
        r.perimeter();
    }
}