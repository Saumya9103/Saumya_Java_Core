package Assignment4;

import java.util.LinkedHashSet;
import java.util.Scanner;

class CourseEnrollment {
    LinkedHashSet<String> students = new LinkedHashSet<>();

    void enrollStudent(String name) {
        if (students.add(name)) {
            System.out.println("Enrolled: " + name);
        } else {
            System.out.println(name + " is already enrolled");
        }
    }

    void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseEnrollment course = new CourseEnrollment();

        while (true) {
            System.out.print("Enter student name (or exit): ");
            String name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }

            course.enrollStudent(name);
        }

        course.displayEnrolledStudents();
        sc.close();
    }
}