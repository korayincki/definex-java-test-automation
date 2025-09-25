package example;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -cp target/classes example.Main <text> [<text2> ...]");
            System.out.println("Example:");
            System.out.println("  java -cp target/classes example.Main 'Hello world' 'A man, a plan, a canal: Panama'");
            return;
        }
        for (String input : args) {
            System.out.println("Input: " + input);
            System.out.println("  countWords = " + TextUtils.countWords(input));
            System.out.println("  isPalindrome = " + TextUtils.isPalindrome(input));
            System.out.println();
        }
    }
}
