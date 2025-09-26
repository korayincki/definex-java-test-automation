package capstone;

import java.util.Objects;

public class OrderLine {
    private final String sku;
    private final int quantity;
    private final int unitPriceCents;

    public OrderLine(String sku, int quantity, int unitPriceCents) {
        this.sku = Objects.requireNonNull(sku, "sku");
        if (quantity <= 0) throw new IllegalArgumentException("quantity must be > 0");
        if (unitPriceCents < 0) throw new IllegalArgumentException("unitPriceCents must be >= 0");
        this.quantity = quantity;
        this.unitPriceCents = unitPriceCents;
    }

    public String getSku() { return sku; }
    public int getQuantity() { return quantity; }
    public int getUnitPriceCents() { return unitPriceCents; }

    public int lineTotal() {
        long total = (long) quantity * (long) unitPriceCents;
        if (total > Integer.MAX_VALUE) throw new ArithmeticException("line total overflow");
        return (int) total;
    }
}
