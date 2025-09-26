package example;

import lab3.BankAccount;
import lab3.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Lab2: BankAccountTest — TDD")
public class BankAccountTest {

    private BankAccount acc;

    @BeforeEach
    void setUp() { acc = new BankAccount(); }


    //inital balance
    @DisplayName("initalBalanceEqualsZero")
    @Test
    void initalBalanceEqualsZero() {
        assertEquals(0,acc.getBalance());
        // throw new UnsupportedOperationException("assert that IllegalArgumentException is thrown");
    }

    // negative deposit
    @DisplayName("Negative Deposit Thown IllegalArgumentExpcetion")
    @Test
    void negativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(-20));
        // throw new UnsupportedOperationException("assert that IllegalArgumentException is thrown");
    }

    // postive deposit
    @DisplayName("Positive Deposit")
    @ParameterizedTest(name = "[{index}] deposit={0}, balance={1}")
    @CsvSource({
            "10 20 30, 60",
            "10 0, 10",
            "1000 400, 1400"
    })
    void positiveDeposit(String depositsStr, int balance) {
        // stringi array'e çevir
        int[] deposits = Arrays.stream(depositsStr.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int dep : deposits) {
            acc.deposit(dep);
        }

        assertEquals(balance, acc.getBalance());
    }

    // negative withdraw
    @DisplayName("Negative Withdraw Thown IllegalArgumentExpcetion")
    @Test
    void negativeWithdraw() {
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-20));
        // throw new UnsupportedOperationException("assert that IllegalArgumentException is thrown");
    }

    // withdraw
    @DisplayName("Positive Withdraw")
    @ParameterizedTest(name = "[{index}] deposit={0}, withdraws= {1}, balance={2}")
    @CsvSource({
            "10 20 30,10 20 30, 0",
            "10 0,5, 5",
            "1000 400,1399,1"
    })
    void positiveWithdraw(String depositsStr, String withdrawsStr, int balance){
        // stringi array'e çevir
        int[] deposits = Arrays.stream(depositsStr.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int dep : deposits) {
            acc.deposit(dep);
        }

        // stringi array'e çevir
        int[] withdraws = Arrays.stream(withdrawsStr.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int draw : withdraws) {
            acc.withdraw(draw);
        }

        assertEquals(balance, acc.getBalance());

    }


    // insufficent withdraw
    @DisplayName("Negative Deposit Thown IllegalArgumentExpcetion")
    @Test
    void insufficentWithdraw() {
        assertThrows(InsufficientFundsException.class, () -> acc.withdraw(20));
    }




}
