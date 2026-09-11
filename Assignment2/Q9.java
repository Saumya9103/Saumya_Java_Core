package Assignment2;

class Base{

    public Base(){
        System.out.println("Base Constructor Called.");
    }
}

class Derived extends Base {

    public Derived(){
        super();
        System.out.println("Derived Constructor Called.");
    }
}

public class Q9 {
    public static void main (String[] args) {
        Derived object = new Derived();
    }
}
