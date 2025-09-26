package capstone;

public class PricingService {

    private final OrderValidator validator;

    public PricingService(OrderValidator validator) {
        this.validator = validator;
    }

    public int price(Order order) {
        validator.validate(order);

        int subtotal = order.getLines().stream()
                .mapToInt(line -> line.getQuantity() * line.getUnitPriceCents())
                .sum();
        int totalItems = order.getLines().stream()
                .mapToInt(OrderLine::getQuantity)
                .sum();

        int discount = 0;

        if (order.isFirstTimeBuyer() && totalItems >= 2) {
            discount += subtotal * 10 / 100;
        }

        if (totalItems > 10) {
            discount += 700;
        }

        int maxDiscount = subtotal * 25 / 100;
        if (discount > maxDiscount) {
            discount = maxDiscount;
        }

        int shipping;
        if (subtotal >= 10_000) {
            shipping = 0; // free shipping
        } else {
            shipping = 1200; // standard shipping
        }

        if (order.isFragile()) {
            shipping += 500; // fragile surcharge
        }

        return subtotal - discount + shipping;
    }
}
