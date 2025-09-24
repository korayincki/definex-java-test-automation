package lab0;

import org.junit.jupiter.api.*;

@DisplayName("Lab0: DiscountCalculator – percentage tiers to discount amount")
class Lab0Smoke {

    private DiscountCalculator calc;

    @BeforeAll
    static void beforeAll() {
        // One-time suite initialization (if needed)
    }

    @BeforeEach
    void setUp() {
        calc = new DiscountCalculator();
    }

    @Test
    @DisplayName("< 100 → 0% discount (amount = 0)")
    void belowHundred() {
        throw new UnsupportedOperationException("assert that 0, 1, 50, 99 yield 0");
    }

    @Test
    @DisplayName("100–199 → 10% discount")
    void hundredToOneNinetyNine() {
        throw new UnsupportedOperationException("assert that 100, 150, 199 yield 10% of input");
    }

    @Test
    @DisplayName("200–300 → 25% discount")
    void twoHundredToThreeHundred() {
        throw new UnsupportedOperationException("assert that 200, 250, 300 yield 25% of input");
    }

    @Test
    @DisplayName("> 300 → 30% discount")
    void aboveThreeHundred() {
        throw new UnsupportedOperationException("assert that 301, 450 yield 30% of input");
    }

    @AfterEach
    void tearDown() {
        // Per-test cleanup (if any)
    }

    @AfterAll
    static void afterAll() {
        // One-time cleanup (if any)
    }
}
