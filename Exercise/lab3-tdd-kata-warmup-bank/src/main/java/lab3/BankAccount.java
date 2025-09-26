package lab3;

public class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        if(amount > balance){
            balance = amount;
        }
    }

    public void withdraw(int amount) {
        if(amount > balance){
            throw new InsufficientFundsException("");
        }
    }

    public int getBalance() {
        return balance;
    }
}
