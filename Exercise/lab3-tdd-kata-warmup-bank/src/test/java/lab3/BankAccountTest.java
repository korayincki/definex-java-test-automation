package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setUp(){
        account = new BankAccount();
    }

    @Test
    void testDepositValueLessThan0(){
        account.deposit(-10);
        assertEquals(0, account.getBalance());
    }

    @Test
    void testWithdrawAmountBiggerBalance(){
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(30));
    }

    @Test
    void testDepositValueEquals0orValueBiggerThan0(){
        account.deposit(70);
        assertEquals(70, account.getBalance());
    }

}