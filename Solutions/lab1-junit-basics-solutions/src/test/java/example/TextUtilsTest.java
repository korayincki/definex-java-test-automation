package example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TextUtils solutions: word count and palindrome (non-parameterized)")
class TextUtilsTest {

    @BeforeAll
    static void beforeAll() { }

    @BeforeEach
    void setUp() { }

    @AfterEach
    void tearDown() { }

    @AfterAll
    static void afterAll() { }

    // ---- countWords ----

    @Test
    @DisplayName("countWords: null returns 0")
    void countWords_null_returnsZero() {
        assertEquals(0, TextUtils.countWords((String) null));
    }

    @Test
    @DisplayName("countWords: empty returns 0")
    void countWords_empty_returnsZero() {
        assertEquals(0, TextUtils.countWords(""));
    }

    @Test
    @DisplayName("countWords: whitespace only (spaces) returns 0")
    void countWords_whitespaceOnly_returnsZero() {
        assertEquals(0, TextUtils.countWords("   ")); // three spaces
    }

    @Test
    @DisplayName("countWords: normal sentences")
    void countWords_normal_sentences() {
        assertEquals(2, TextUtils.countWords("Hello world"));
        assertEquals(4, TextUtils.countWords("Trim   multiple   spaces  here"));
        assertEquals(3, TextUtils.countWords(" one two three "));
    }

    // ---- isPalindrome ----

    @Test
    @DisplayName("isPalindrome: Panama example returns true")
    void isPalindrome_true_panama() {
        assertTrue(TextUtils.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    @DisplayName("isPalindrome: Nixon example returns true")
    void isPalindrome_true_nixon() {
        assertTrue(TextUtils.isPalindrome("No 'x' in Nixon"));
    }

    @Test
    @DisplayName("isPalindrome: Was it a car or a cat I saw returns true")
    void isPalindrome_true_wasIt() {
        assertTrue(TextUtils.isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    @DisplayName("isPalindrome: Able was I ere I saw Elba returns true")
    void isPalindrome_true_ableWasI() {
        assertTrue(TextUtils.isPalindrome("Able was I ere I saw Elba"));
    }

    @Test
    @DisplayName("isPalindrome: Not a palindrome returns false")
    void isPalindrome_false_not() {
        assertFalse(TextUtils.isPalindrome("Not a palindrome"));
    }

    @Test
    @DisplayName("isPalindrome: Hello returns false")
    void isPalindrome_false_hello() {
        assertFalse(TextUtils.isPalindrome("Hello"));
    }

    @Test
    @DisplayName("isPalindrome: abcbaX returns false")
    void isPalindrome_false_abcbax() {
        assertFalse(TextUtils.isPalindrome("abcbaX"));
    }

    @Test
    @DisplayName("isPalindrome: null returns false")
    void isPalindrome_null() {
        assertFalse(TextUtils.isPalindrome(null));
    }

    @Test
    @DisplayName("isPalindrome: only symbols returns true (empty after strip)")
    void isPalindrome_symbols_only() {
        assertTrue(TextUtils.isPalindrome("!!!"));
        assertTrue(TextUtils.isPalindrome("...   ..."));
    }
}
