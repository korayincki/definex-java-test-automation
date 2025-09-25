package tools;

import example.TextUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextUtilsTest {

    @ParameterizedTest
    @CsvSource({
        "Hello world, 2",
        "'  Leading and trailing spaces  ', 4",
        "'Multiple   spaces between words', 4",
        "'SingleWord', 1",
        "'    ', 0",
    })
    void countWords(String input, int expected) {
        // act
        var result = TextUtils.countWords(input);

        // assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "ada, true",
            "kayak, true",
            "level, true",
            "madam, true",
            "hello, false",
            "world, false",
            "'', true",
            "a, true"
    })
    void isPalindrome(String input, boolean expected) {
        // act
        var result = TextUtils.isPalindrome(input);

        // assert
        assertEquals(expected, result);
    }
}
