package Assignment2;

class Person{

    protected String name;
    protected byte age;

    public Person(String name, byte age){
        this.name = name;
        this.age = age;
    }

    public void displayPersonDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Employee extends Person {
    private String empId;
    private double salary;

    public Employee(String name, byte age, String empId, double salary) {
        super(name,age);

        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        displayPersonDetails();

        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }
}

public class Q6 {
    public static void main (String[] args) {
        Employee e = new Employee("Alice",(byte) 30,"E123",50000.00);
        e.displayEmployeeDetails();
    }
}
