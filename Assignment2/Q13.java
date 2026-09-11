package Assignment2;

class Parents {
    int value = 50;

    Parents() {
        System.out.println("Parent constructor called");
    }

    void displays() {
        System.out.println("Parent method called");
    }
}

class Childs extends Parents {

    Childs() {
        super();
    }

    void shows() {
        super.displays();
        System.out.println("Parent variable value: " + super.value);
    }
}

public class Q13 {
    public static void main(String[] args) {

        Childs obj = new Childs();

        obj.shows();
    }
}