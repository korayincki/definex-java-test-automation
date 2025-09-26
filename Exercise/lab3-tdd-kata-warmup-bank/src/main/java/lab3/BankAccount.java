package lab3;

public class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(int amount) {
        if(amount < 0 || amount > this.balance) {
            throw new InsufficientFundsException("Insufficient Funds");
        }
        this.balance -= amount;
    }

    public int getBalance() {
        return balance; // starts at 0
    }
}
