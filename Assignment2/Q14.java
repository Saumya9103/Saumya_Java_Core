package Assignment2;

class Garbage {

    protected void finalize() {
        System.out.println("Object destroyed");
    }
}

public class Q14 {
    public static void main(String[] args) {

        Garbage garbage1 = new Garbage();
        Garbage garbage2 = new Garbage();

        garbage1 = null;
        garbage2 = null;

        System.gc();
    }
}