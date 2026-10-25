
package Assignment3;

// Shared resource
class TicketBooking {
    private int availableSeats;

    TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Synchronized method to prevent race conditions
    synchronized void bookSeat(int seats) {
        String userName = Thread.currentThread().getName();

        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println(userName + " booked " + seats
                    + " seat(s) successfully");
        } else {
            System.out.println(userName
                    + " booking failed. Not enough seats");
        }
    }
}

// Thread class for User1
class User1 extends Thread {
    private TicketBooking booking;
    private int seats;

    User1(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
        setName("User1");
    }

    public void run() {
        booking.bookSeat(seats);
    }
}

// Thread class for User2
class User2 extends Thread {
    private TicketBooking booking;
    private int seats;

    User2(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
        setName("User2");
    }

    public void run() {
        booking.bookSeat(seats);
    }
}

public class Q7 {
    public static void main(String[] args) {

        int availableSeats = 2;
        int user1Seats = 1;
        int user2Seats = 2;

        System.out.println("Available Seats: " + availableSeats);
        System.out.println("User1 wants to book: " + user1Seats);
        System.out.println("User2 wants to book: " + user2Seats);

        TicketBooking booking = new TicketBooking(availableSeats);

        User1 user1 = new User1(booking, user1Seats);
        User2 user2 = new User2(booking, user2Seats);

        user1.start();
        user2.start();
    }
}

