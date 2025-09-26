package example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lab0: DiscountCalculator – percentage tiers to discount amount")
public class TextUtilsTest {




    @BeforeAll
    static void beforeAll() {
        // One-time suite initialization (if needed)
    }

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource(value = {
            "' ',      0",
            "'        ',      0",
            "'',      0",
            " ,      0",
            ",        0",
    })
    @DisplayName("Empty strings")
    void countWordswithZeroWords(String string, int count) {
        assertEquals(0,TextUtils.countWords(string));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'lemon lime', 2",
            "strawberry ,    1",
            "Hello world ,    2"
    })
    @DisplayName("sentence -> word count")
    void countWordsWithSentences(String string, int count) {
        assertEquals(count,TextUtils.countWords(string));
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" , "A man, a plan, a canal: Panama" })
    void palindromesShouldReturnTrue(String candidate) {
        assertTrue(TextUtils.isPalindrome(candidate));
    }
    @ParameterizedTest
    @ValueSource(strings = { "ahmet", "radak", "able was S ere I saw elba" })
    @NullSource
    void palindromesShouldReturnFalse(String candidate) {
        assertFalse(TextUtils.isPalindrome(candidate));
    }



}