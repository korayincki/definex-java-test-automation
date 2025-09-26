package lab3;

public class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        if (amount <0){
            throw new IllegalArgumentException("You can't deposit negative amount.");
        }
        balance+= amount;
      //  throw new UnsupportedOperationException("TDD: implement deposit");
    }

    public void withdraw(int amount) {
        if (amount <0){
            throw new IllegalArgumentException("You can't deposit negative amount.");
        }
        if (balance -amount < 0){
            throw new InsufficientFundsException("InsufficientFunds");
        }
        balance-=amount;
    }

    public int getBalance() {
        return balance; // starts at 0
    }
}
