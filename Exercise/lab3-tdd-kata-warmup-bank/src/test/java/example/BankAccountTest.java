package example;

import lab3.BankAccount;
import lab3.IllegalAmountException;
import lab3.InsufficientFundsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1})
    public void negativeWithdrawShouldThrowIllegalAmountException(int amount) {
        // act
        Runnable withdraw = () -> bankAccount.withdraw(amount);

        // assert
        Assertions.assertThrows(IllegalAmountException.class, withdraw::run);
    }

    @ParameterizedTest
    @CsvSource({
        "100, 10",
        "10, 10",
        "0, 0"
    })
    public void negativeAmountWithdrawShouldThrowIllegalAmountException(int balance, int amount) {
        // arrange
        var expected = balance - amount;
        bankAccount.deposit(balance);

        // act
        bankAccount.withdraw(amount);

        // assert
        Assertions.assertEquals(expected, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100})
    public void depositShouldSuccess(int amount) {
        // act
        bankAccount.deposit(amount);

        // assert
        Assertions.assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1})
    public void negativeAmountDepositShouldThrowIllegalAmountException(int amount) {
        // act
        Runnable withdraw = () -> bankAccount.deposit(amount);

        // assert
        Assertions.assertThrows(IllegalAmountException.class, withdraw::run);
    }

    @ParameterizedTest
    @CsvSource({
            "100, 10"
    })
    public void overBalanceWithdrawShouldThrowInsufficientFundsException(int amount, int balance) {
        // arrange
        bankAccount.deposit(balance);

        // act
        Runnable withdraw = () -> bankAccount.withdraw(amount);

        // assert
        Assertions.assertThrows(InsufficientFundsException.class, withdraw::run);
    }
}
