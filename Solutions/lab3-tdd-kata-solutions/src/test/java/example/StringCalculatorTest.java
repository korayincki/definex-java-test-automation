package example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("StringCalculator solution tests")
class StringCalculatorTest {
    @BeforeAll static void beforeAll() { }
    @BeforeEach void setUp() { }
    @AfterEach void tearDown() { }
    @AfterAll static void afterAll() { }

    @Test
    @DisplayName("empty string -> 0")
    void empty() {
        assertEquals(0, new StringCalculator().add(""));
    }

    @Test
    @DisplayName("single number")
    void single() {
        assertEquals(7, new StringCalculator().add("7"));
    }

    @Test
    @DisplayName("two comma-separated numbers")
    void two() {
        assertEquals(3, new StringCalculator().add("1,2"));
    }
}
