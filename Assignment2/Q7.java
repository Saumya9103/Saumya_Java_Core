package Assignment2;

class Animal{

    protected String animalType;

    public Animal(String animalType){
        this.animalType =animalType;
    }

    public void displayAnimalType(){
        System.out.println("Animal Type: " + animalType);
    }
}

class Mammal extends Animal{

    public Mammal(String animalType){
        super(animalType);
    }
}

class Dog extends Mammal {

    private String name;
    private String breed;

    public Dog(String name, String breed){
        super("Mammal");

        this.name=name;
        this.breed=breed;
    }

    public void displayDetails(){
        System.out.println("Dog Name: " + name);
        System.out.println("Dog Breed: " + breed);

        displayAnimalType();
    }
}

public class Q7 {
    public static void main (String[] args) {
        Dog dog = new Dog ("Buddy", "Labrador");

        dog.displayDetails();
    }
}
