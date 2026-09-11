package Assignment2;

class Vehicle {

    public void start() {
        System.out.println("Vehicle is starting.... ");
    }
}

class Car extends Vehicle {

    @Override
    public void start(){
        System.out.println("Car is starting....");
    }
}

class Bike extends Vehicle {

    @Override
    public void start(){
        System.out.println("Bike is starting....");
    }
}

public class Q8 {
    public static void main (String[] args) {
        Vehicle vehicle = new Vehicle();
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        vehicle.start();
        car.start();
        bike.start();
    }
}
