package example;

import java.util.Locale;

public class TextUtils {
    public static int countWords(String s) {
        if (s == null || s.trim().isEmpty())
            return 0;
        return s.trim().split("\\s+").length;
    }

    public static boolean isPalindrome(String s) {
        if (s == null)
            return false;
        // Use locale-insensitive lowercasing to avoid Turkish-i issues
        String t = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
        return new StringBuilder(t).reverse().toString().equals(t);
    }
}
