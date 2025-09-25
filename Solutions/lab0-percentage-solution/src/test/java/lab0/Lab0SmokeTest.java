package lab0;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lab0 Solutions: DiscountCalculator — percentage tiers to discount amount")
class Lab0SmokeTest {

    private DiscountCalculator calc;

    @BeforeAll
    static void beforeAll() {
        // could configure logging once, initialize shared resources, etc.
    }

    @BeforeEach
    void setUp() {
        calc = new DiscountCalculator();
    }

    @Test
    @DisplayName("< 100 → 0% discount (amount = 0)")
    void belowHundred() {
        assertEquals(0, calc.calculate(0));
        assertEquals(0, calc.calculate(1));
        assertEquals(0, calc.calculate(50));
        assertEquals(0, calc.calculate(99));
    }

    @Test
    @DisplayName("100–199 → 10% discount (integer truncation applies)")
    void hundredToOneNinetyNine() {
        assertEquals(10, calc.calculate(100));     // 10% of 100 = 10
        assertEquals(15, calc.calculate(150));     // 15
        assertEquals(19, calc.calculate(199));     // 19.9 -> 19
    }

    @Test
    @DisplayName("200–300 → 25% discount")
    void twoHundredToThreeHundred() {
        assertEquals(50, calc.calculate(200));     // 25% of 200 = 50
        assertEquals(62, calc.calculate(250));     // 62.5 -> 62
        assertEquals(75, calc.calculate(300));     // 75
    }

    @Test
    @DisplayName("> 300 → 30% discount")
    void aboveThreeHundred() {
        assertEquals(90, calc.calculate(301));     // 30% of 301 = 90.3 -> 90
        assertEquals(135, calc.calculate(450));    // 135
        assertEquals(3000, calc.calculate(10000)); // 3000
    }

    @Test
    @DisplayName("Negative values throw IllegalArgumentException")
    void negativeValues() {
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(-1));
        assertThrows(IllegalArgumentException.class, () -> calc.calculate(-100));
    }

    @AfterEach
    void tearDown() {
        // Clean up per-test if needed
    }

    @AfterAll
    static void afterAll() {
        // Clean up once per-class if needed
    }
}
