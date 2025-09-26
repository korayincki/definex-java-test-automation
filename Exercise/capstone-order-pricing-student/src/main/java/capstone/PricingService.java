package capstone;

/**
 * Implement price(Order) per README rules.
 * Keep all currency in **cents** (int). Apply caps carefully.
 */
public class PricingService {

    private final OrderValidator validator;

    public PricingService(OrderValidator validator) {
        this.validator = validator;
    }

    /**
     * Compute final price in cents. Steps (suggested):
     * 1) validator.validate(order)
     * 2) compute subtotal and totalItems
     * 3) compute discounts:
     *    - 10% if (first-time && totalItems >= 2)
     *    - +700 if (totalItems > 10)
     *    - cap total discount at 25% of subtotal
     * 4) compute shipping:
     *    - 0 if subtotal >= 10_000 else 1200
     *    - +500 if order.fragile == true
     * 5) return subtotal - discount + shipping
     */
    public int price(Order order) {
        throw new UnsupportedOperationException("Implement in capstone");
    }
}
