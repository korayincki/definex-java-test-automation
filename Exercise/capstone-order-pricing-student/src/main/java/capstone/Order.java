package capstone;

import java.util.*;

public class Order {
    private final List<OrderLine> lines = new ArrayList<>();
    private boolean firstTimeBuyer;
    private boolean fragile;

    public Order firstTimeBuyer(boolean v) { this.firstTimeBuyer = v; return this; }
    public Order fragile(boolean v) { this.fragile = v; return this; }

    public boolean isFirstTimeBuyer() { return firstTimeBuyer; }
    public boolean isFragile() { return fragile; }

    public Order addLine(OrderLine line) { lines.add(Objects.requireNonNull(line)); return this; }
    public List<OrderLine> getLines() { return Collections.unmodifiableList(lines); }

    public int subtotal() {
        long s = 0;
        for (var l : lines) {
            s += l.lineTotal();
        }
        if (s > Integer.MAX_VALUE) throw new ArithmeticException("subtotal overflow");
        return (int) s;
    }

    public int totalItems() {
        long items = 0;
        for (var l : lines) items += l.getQuantity();
        if (items > Integer.MAX_VALUE) throw new ArithmeticException("items overflow");
        return (int) items;
    }
}
