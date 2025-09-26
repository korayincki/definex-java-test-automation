package lab3;

public class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        if(amount < 0) throw new IllegalAmountException("Amount must be positive");
        balance += amount;
    }

    public void withdraw(int amount) {
        if(amount < 0) throw new IllegalAmountException("Amount must be positive");
        if(amount > balance) throw new InsufficientFundsException("Amount must be less than balance");
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
