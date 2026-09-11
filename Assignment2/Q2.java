package Assignment2;

class BankAccount{

    private long accountNumber;
    private double balance;

    public void setAccountDetails(long accountNumber, double initialBalance){

        if (accountNumber <= 0) {
            System.out.println("Invalid account number.");
            return;
        }

        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative.");
            return;
        }

        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount){

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        balance += amount;

        System.out.printf("Deposit successful. Current Balance: %2f%n", balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        if (amount > balance) {
            System.out.println("Withdrawal failed. Insufficient Balance.");
            return;
        }

        balance -= amount;

        System.out.printf("Withdrawal successful. Remaining Balance: %2f%n", balance);
    }

    public void checkBalance() {

        System.out.printf("Current Balance: %2f%n", balance);
    }
}
public class Q2 {
    public static void main(String[] args){
        BankAccount account = new BankAccount();

        account.setAccountDetails(12345L, 1000.00);

        account.deposit(500.00);
        account.withdraw(300.00);

        account.checkBalance();
    }
}
