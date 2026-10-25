
package Assignment3;

// Bank transaction thread
class BankTransaction extends Thread {
    private double amount;

    BankTransaction(String name, double amount) {
        super(name);
        this.amount = amount;
    }

    @Override
    public void run() {
        if (amount >= 50000) {
            System.out.println("High-value transaction processed first");
        } else {
            System.out.println("Low-value transaction processed later");
        }
    }
}

public class Q10 {
    public static void main(String[] args) {

        BankTransaction transaction1 =
                new BankTransaction("Transaction1", 5000);

        BankTransaction transaction2 =
                new BankTransaction("Transaction2", 50000);

        // Set thread priorities
        transaction1.setPriority(Thread.MIN_PRIORITY);
        transaction2.setPriority(Thread.MAX_PRIORITY);

        // Start high-priority transaction first
        transaction2.start();
        transaction1.start();
    }
}
