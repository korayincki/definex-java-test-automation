package lab3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BankAccount solution tests")
class BankAccountTest {

    private BankAccount account;

    @BeforeAll
    static void beforeAll() { }

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @AfterEach
    void tearDown() { }

    @AfterAll
    static void afterAll() { }

    @Test
    @DisplayName("new account has zero balance")
    void newAccountZeroBalance() {
        assertEquals(0, account.getBalance());
    }

    @Test
    @DisplayName("deposit increases balance")
    void depositIncreasesBalance() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    @DisplayName("deposit negative amount throws")
    void depositNegativeThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(-1));
        assertTrue(ex.getMessage().toLowerCase().contains("non-negative"));
    }

    @Test
    @DisplayName("withdraw reduces balance")
    void withdrawReducesBalance() {
        account.deposit(100);
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }

    @Test
    @DisplayName("withdraw equal to balance goes to zero")
    void withdrawEqualToBalance() {
        account.deposit(70);
        account.withdraw(70);
        assertEquals(0, account.getBalance());
    }

    @Test
    @DisplayName("withdraw negative amount throws")
    void withdrawNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5));
    }

    @Test
    @DisplayName("withdraw more than balance throws InsufficientFundsException")
    void withdrawMoreThanBalanceThrows() {
        account.deposit(40);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(50));
    }
}
