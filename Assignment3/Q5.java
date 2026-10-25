
package Assignment3;

import java.util.Scanner;

class UniversityLogin {

    void login(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }

        System.out.println("Login successful. Welcome, " + username);
    }
}

public class Q5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        // Convert the text "null" into an actual null reference
        if (username.equalsIgnoreCase("null")) {
            username = null;
        }

        UniversityLogin user = new UniversityLogin();

        try {
            user.login(username);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
