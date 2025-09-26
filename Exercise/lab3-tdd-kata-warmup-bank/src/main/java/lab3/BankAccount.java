package lab3;

public class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        if(amount < 0)
        throw new UnsupportedOperationException("TDD: implement deposit");
        else
        balance = balance + amount;
    }

    public void withdraw(int amount) {
        if(amount < 0)
        throw new UnsupportedOperationException("TDD: implement withdraw");
        else{
            if(balance < amount){
                throw new UnsupportedOperationException("yetersiz");
            }
            else{
                balance = balance - amount;
            }
        }
    }

    public int getBalance() {
        return balance; // starts at 0
    }
}
