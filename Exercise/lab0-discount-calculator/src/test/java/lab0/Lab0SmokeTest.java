package lab0;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lab0: DiscountCalculator – percentage tiers to discount amount")
class Lab0SmokeTest {

    private DiscountCalculator calc;

    @BeforeAll
    static void beforeAll() {
        // One-time suite initialization (if needed)
    }

    @BeforeEach
    void setUp() {
        calc = new DiscountCalculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 50, 99})
    @DisplayName("< 100 → 0% discount (amount = 0)")
    void belowHundred(int amount) {
        // arrange
        var expected = 0;

        // act
        var result = calc.calculate(amount);

        // assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 150, 199})
    @DisplayName("100–199 → 10% discount")
    void hundredToOneNinetyNine(int amount) {
        // arrange
        var expected = amount / 10;

        // act
        var result = calc.calculate(amount);

        // assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 250, 300})
    @DisplayName("200–300 → 25% discount")
    void twoHundredToThreeHundred(int amount) {
        // arrange
        var expected = (amount * 25) / 100;

        // act
        var result = calc.calculate(amount);

        // assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {301, 400, 999999})
    @DisplayName("> 300 → 30% discount")
    void aboveThreeHundred(int amount) {
        // arrange
        var expected = (amount * 30) / 100;

        // act
        var result = calc.calculate(amount);

        // assert
        assertEquals(expected, result);
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
