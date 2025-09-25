package lab2;

public class TaxCalculator {

    /**
     * Computes net salary given gross salary and tax rate percentage.
     * @param gross positive integer gross
     * @param taxRatePercent integer [0..100]
     * @return net = gross - (gross * taxRatePercent / 100)
     * @throws IllegalArgumentException if gross < 0 or taxRatePercent outside [0..100]
     */
    public int netSalary(int gross, int taxRatePercent) {
        if (gross < 0) {
            throw new IllegalArgumentException("gross must be non-negative");
        }
        if (taxRatePercent < 0 || taxRatePercent > 100) {
            throw new IllegalArgumentException("taxRate must be between 0 and 100");
        }
        return gross - (gross * taxRatePercent / 100);
    }
}
