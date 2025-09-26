package lab3;

public class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("insufficient funds");
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
