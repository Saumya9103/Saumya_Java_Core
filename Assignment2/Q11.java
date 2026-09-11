package Assignment2;

final class FinalClass{
    public final void display() {
        System.out.println("Final method executed.");
    }
}

class Parent {
    public final void show(){
        System.out.println("Final method executed.");
    }
}

class Child extends Parent {
    /*@Override
    public void show() {
        System.out.println("Cannot override final method");
    }*/
}

public class Q11 {
    public static void main (String[] args) {
        final byte FINAL_VALUE = 100;

        System.out.println("Final variable value: " + FINAL_VALUE);

        FinalClass object = new FinalClass();

        object.display();

        System.out.println("Cannot inherit from final class.");

        Child child = new Child();
        child.show();

        System.out.println("Cannot override final method.");
    }
}
