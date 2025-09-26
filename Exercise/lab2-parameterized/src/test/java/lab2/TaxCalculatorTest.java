package lab2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lab2: TaxCalculator — CSV-driven parameterized tests")
class TaxCalculatorTest {

    private TaxCalculator calc;

    @BeforeAll
    static void beforeAll() { /* suite init if needed */ }

    @BeforeEach
    void setUp() { calc = new TaxCalculator(); }

    @ParameterizedTest(name = "[{index}] gross={0}, tax={1}% -> net={2}")
    @CsvSource({
        "5000, 20, 4000",
        "10000, 35, 6500",
        "0, 0, 0",
        "100, 100, 0"
    })
    @DisplayName("valid cases")
    void validCases(int gross, int tax, int expectedNet) {
        assertEquals(expectedNet,calc.netSalary(gross,tax));
      //  throw new UnsupportedOperationException("compute net via calc.netSalary and assert equals expectedNet");
    }

    @ParameterizedTest(name = "[{index}] gross={0}, tax={1}% -> error")
    @CsvSource({
        "-1, 10",
        "100, -1",
        "100, 101"
    })
    @DisplayName("error cases (invalid inputs)")
    void errorCases(int gross, int tax) {
        assertThrows(IllegalArgumentException.class, () -> calc.netSalary(gross, tax));
       // throw new UnsupportedOperationException("assert that IllegalArgumentException is thrown");
    }

    @AfterEach
    void tearDown() { /* per-test cleanup if needed */ }

    @AfterAll
    static void afterAll() { /* suite cleanup */ }
}
