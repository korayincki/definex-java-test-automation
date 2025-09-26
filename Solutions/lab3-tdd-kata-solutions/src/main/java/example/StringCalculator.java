package example;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) return 0;
        String[] parts = input.split(",");
        int sum = 0;
        for (String p : parts) {
            String t = p.trim();
            if (!t.isEmpty()) {
                sum += Integer.parseInt(t);
            }
        }
        return sum;
    }
}
