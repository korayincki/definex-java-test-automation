package lab2;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0 || args.length % 2 != 0) {
            System.out.println("Usage: java -cp target/classes lab2.Main <gross1> <tax1> [<gross2> <tax2> ...]");
            System.out.println("Example: java -cp target/classes lab2.Main 5000 20 10000 35");
            return;
        }
        TaxCalculator calc = new TaxCalculator();
        for (int i = 0; i < args.length; i += 2) {
            try {
                int gross = Integer.parseInt(args[i]);
                int tax = Integer.parseInt(args[i + 1]);
                int net = calc.netSalary(gross, tax);
                System.out.printf("Gross=%d Tax=%d%% -> Net=%d%n", gross, tax, net);
            } catch (NumberFormatException nfe) {
                System.out.printf("Input error at args[%d,%d]: not integers%n", i, i+1);
            } catch (IllegalArgumentException iae) {
                System.out.printf("Input error at args[%d,%d]: %s%n", i, i+1, iae.getMessage());
            }
        }
    }
}
