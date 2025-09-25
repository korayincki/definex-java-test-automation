package example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextUtilsTest {


    @ParameterizedTest
    @CsvSource(value = {"0,''",
    "0,",
            "1,'null'",
    "0,' '",
    "2,'Hello world'"}
    )
    void countWords(int expected, String s) {
        assertEquals(expected, TextUtils.countWords(s));
    }

    @ParameterizedTest
    @CsvSource(value = {"true,''",
            "false,null",
            "true,' '",
            "true,'A man, a plan, a canal: Panama'",
            "false,'Not a palindrome'"}
    )
    void palindrome(boolean expected, String s) {
        assertEquals(expected,TextUtils.isPalindrome(s));
    }
}