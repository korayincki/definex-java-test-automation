package example;

public class StringCalculator {
    public int add(String input) {
        var result = 0;

        if (input == null || input.isEmpty()) {
            return result;
        }

        for(char c : input.replace(",","").toCharArray()) {
            result += Integer.parseInt(String.valueOf(c));
        }

        return result;
    }
}
