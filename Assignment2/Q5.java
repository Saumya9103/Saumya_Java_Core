package Assignment2;

class Students{

    private String name;
    private int rollNumber;

    public Students(){
        this.name="Unknown";
        this.rollNumber=0;
    }

    public Students(String name, int rollNumber){
        this.name=name;
        this.rollNumber=rollNumber;
    }

    public Students(Students otherStudent){
        this.name= otherStudent.name;
        this.rollNumber= otherStudent.rollNumber;
    }

    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

public class Q5 {
    public static void main (String[] args){

        Students s1 = new Students();

        Students s2 = new Students("Saumya", 28);

        Students s3 = new Students(s2);

        System.out.println("Student 1:");
        s1.displayDetails();

        System.out.println("\nStudent 2:");
        s2.displayDetails();

        System.out.println("\nStudent 3:");
        s3.displayDetails();
    }
}
