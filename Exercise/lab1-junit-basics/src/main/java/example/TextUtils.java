package example;

public class TextUtils {
    public static int countWords(String s) {
        if (s == null || s.trim().isEmpty())
            return 0;
        return s.trim().split("\\s+").length;
    }

    public static boolean isPalindrome(String s) {
        if (s == null)
            return false;
        String t = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return new StringBuilder(t).reverse().toString().equals(t);
    }
}
