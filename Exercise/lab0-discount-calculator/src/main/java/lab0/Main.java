package lab0;

public class Main {
    public static void main(String[] args) {
        DiscountCalculator calc = new DiscountCalculator();
        if (args.length == 0) {
            System.out.println("Usage: java -cp target/classes lab0.Main <orderValue> [<orderValue> ...]");
            System.out.println("Example: 50 120 250 301 -3");
            return;
        }
        for (String a : args) {
            try {
                int val = Integer.parseInt(a);
                int discount = calc.calculate(val);
                System.out.printf("Order=%d -> Discount=%d%n", val, discount);
            } catch (NumberFormatException nfe) {
                System.out.printf("Order=%s -> Error: not an integer%n", a);
            } catch (IllegalArgumentException iae) {
                System.out.printf("Order=%s -> Error: %s%n", a, iae.getMessage());
            }
        }
    }
}
