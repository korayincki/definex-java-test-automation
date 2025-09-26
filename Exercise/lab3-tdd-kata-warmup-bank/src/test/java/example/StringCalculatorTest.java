package example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @Test
    void empty() {
        assertEquals(0, new StringCalculator().add(""));
    }

    @Test
    void single() {
        assertEquals(7, new StringCalculator().add("7"));
    }

    @Test
    void two() {
        assertEquals(3, new StringCalculator().add("1,2"));
    }
}
