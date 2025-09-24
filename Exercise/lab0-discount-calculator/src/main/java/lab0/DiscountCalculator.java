package lab0;

/**
 * DiscountCalculator computes the DISCOUNT AMOUNT (integer) from an order value, using percentage tiers:
 *   - order < 100     -> 0%  of order
 *   - 100..199        -> 10% of order
 *   - 200..300        -> 25% of order
 *   - > 300           -> 30% of order
 *
 * The return value is the discount AMOUNT (not the final price), truncated to an integer.
 * Negative order values are not allowed.
 */
public class DiscountCalculator {

    /**
     * @param orderValue integer order value
     * @return integer discount amount computed from the tiers above
     * @throws IllegalArgumentException if orderValue is negative
     */
    public int calculate(int orderValue) {
        if (orderValue < 0) {
            throw new IllegalArgumentException("order value must be non-negative");
        }
        if (orderValue > 300) {
            return (orderValue * 30) / 100;
        } else if (orderValue >= 200) {
            return (orderValue * 25) / 100;
        } else if (orderValue >= 100) {
            return (orderValue * 10) / 100;
        } else {
            return 0;
        }
    }
}
