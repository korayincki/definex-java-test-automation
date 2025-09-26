package example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab3.BankAccount;

public class BankAccountTest {

    private BankAccount bankAccount;
    private Integer balance;

    @BeforeEach
    void setUp(){
        bankAccount = new BankAccount();
    }

    @Test
    void checkDepositUnderZeroError(){
        assertThrows(UnsupportedOperationException.class, () -> bankAccount.deposit(-10));
    }

    @Test
    void checkDepositIncreaseBalanceCase(){
        bankAccount.deposit(50);
        assertEquals(bankAccount.getBalance(), 50);
        assertDoesNotThrow(() -> bankAccount.deposit(50));
    }

    @Test
    void amountWithdrawBiggerBalanceErrorCase(){
        bankAccount.deposit(50);
        assertThrows( UnsupportedOperationException.class, () -> bankAccount.withdraw(60));
    }
    @Test
    void amountNegativeError(){
        assertThrows( UnsupportedOperationException.class, () -> bankAccount.withdraw(-20));
    }
    @Test
    void amountTrueCase(){
        bankAccount.deposit(50);
        assertDoesNotThrow(() -> bankAccount.withdraw(50));
    }
    @Test
    void returnBalanceCase(){
        assertDoesNotThrow(() -> bankAccount.getBalance());
    }
}
