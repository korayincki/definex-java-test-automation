package capstone;

public class Main {
    public static void main(String[] args) {
        System.out.println("Capstone demo (implement PricingService to see real output):");
        Order o = new Order().firstTimeBuyer(true).fragile(true);
        o.addLine(new OrderLine("A", 2, 3500));
        o.addLine(new OrderLine("B", 9, 800));
        PricingService svc = new PricingService(order -> {
            // simple validator: ensure at least 1 line
            if (order.getLines().isEmpty()) throw new IllegalArgumentException("empty order");
        });
        try {
            int price = svc.price(o);
            System.out.println("Price = " + price + " cents");
        } catch (UnsupportedOperationException e) {
            System.out.println("PricingService not implemented yet.");
        }
    }
}
