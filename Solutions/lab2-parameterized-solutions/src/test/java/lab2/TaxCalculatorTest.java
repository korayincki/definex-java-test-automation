package lab2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TaxCalculator solutions: CSV-driven tests for net salary")
class TaxCalculatorTest {

    private TaxCalculator calc;

    @BeforeAll
    static void beforeAll() { }

    @BeforeEach
    void setUp() { calc = new TaxCalculator(); }

    @AfterEach
    void tearDown() { }

    @AfterAll
    static void afterAll() { }

    @ParameterizedTest(name = "[{index}] gross={0}, tax={1}% -> net={2}")
    @CsvSource({
        "5000, 20, 4000",
        "10000, 35, 6500",
        "0, 0, 0",
        "100, 100, 0",
        "1, 0, 1",
        "1, 100, 0",
        "1234, 25, 926"
    })
    @DisplayName("valid cases")
    void validCases(int gross, int tax, int expectedNet) {
        assertEquals(expectedNet, calc.netSalary(gross, tax));
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
    }
}
