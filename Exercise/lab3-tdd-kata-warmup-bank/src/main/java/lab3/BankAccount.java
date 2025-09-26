package lab3;

public class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        throw new UnsupportedOperationException("TDD: implement deposit");
    }

    public void withdraw(int amount) {
        throw new UnsupportedOperationException("TDD: implement withdraw");
    }

    public int getBalance() {
        return balance;
    }
}
