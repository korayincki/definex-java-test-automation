package lab3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
        account.deposit(20);
    }

    @ParameterizedTest()
    @CsvSource({
            "30,10",
            "20,-20"
    })
    void testDeposit(int expected, int amount) {
        account.deposit(amount);
        assertEquals(expected,account.getBalance());
    }

    @ParameterizedTest()
    @CsvSource({
            "10,10",
    })
    void testWithdraw(int expected, int amount) {
        account.withdraw(amount);
        assertEquals(expected,account.getBalance());
    }

    @ParameterizedTest()
    @CsvSource({
            "-20",
    })
    void testThrowInsufficientWithdraw(int amount) {
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(amount));
    }


}