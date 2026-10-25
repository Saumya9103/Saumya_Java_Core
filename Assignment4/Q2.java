
package Assignment4;

import java.util.HashSet;
import java.util.Scanner;

class Attendance {
    HashSet<String> students = new HashSet<>();

    void markAttendance(String name) {
        if (students.add(name)) {
            System.out.println("Attendance marked for " + name);
        } else {
            System.out.println(name + " is already marked present");
        }
    }

    void displayAttendance() {
        System.out.println("Present Students: " + students);
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attendance attendance = new Attendance();

        while (true) {
            System.out.print(
                    "Enter name to mark attendance (or exit): "
            );

            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            attendance.markAttendance(name);
        }

        attendance.displayAttendance();
        sc.close();
    }
}
