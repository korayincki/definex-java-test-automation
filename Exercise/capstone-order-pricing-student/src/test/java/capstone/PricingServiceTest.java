package capstone;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Student skeleton – fill tests to drive PricingService.
 */
@DisplayName("PricingService unit tests (student skeleton)")
class PricingServiceTest {

    PricingService svc;
    OrderValidator validator;

    @BeforeAll static void beforeAll() { }
    @AfterAll static void afterAll() { }

    @BeforeEach
    void setUp() {
        validator = order -> { /* default: accept all */ };
        svc = new PricingService(validator);
    }

    @AfterEach void tearDown() { }

    @Test
    @DisplayName("basic order with 1 item, non-fragile, not first-time")
    void basicNonFragileNoDiscount() {
        // Build order
        // Assert specific price

        // arrange
        var expected = 2200;

        Order order = new Order();
        order.addLine(new OrderLine("item1", 1, 1000))
            .firstTimeBuyer(false)
            .fragile(false);

        // act
        var price = svc.price(order);

        // assert
        assertEquals(expected, price);
    }

    @ParameterizedTest(name = "[{index}] items={0} firstTime={1} expected={2}")
    @CsvSource({
            "2,true,3000", "10,true,9000", "11,true,9200"
    })
    @DisplayName("threshold tests for first-time and bulk rules")
    void thresholdsFirstTimeAndBulk(int items, boolean firstTime, int expected) {
        // Build an order with 'items' quantity of unit price 1000
        // Then assert price equals expected

        // arrange
        List<OrderLine> orderLines = IntStream.rangeClosed(1, items)
                .mapToObj(i -> new OrderLine("item" + i, 1, 1000))
                .toList();
        Order order = new Order();

        for (OrderLine orderLine : orderLines) {
            order.addLine(orderLine);
        }

        order.firstTimeBuyer(firstTime);

        // act
        var price = svc.price(order);

        // assert
        assertEquals(expected, price);
    }

    @ParameterizedTest
    @CsvSource({
        "9999", "10000", "10001"
    })
    @DisplayName("shipping threshold 9_999 / 10_000 / 10_001")
    void shippingThresholds(int unitPriceCents) {
        // Build orders around the shipping free threshold

        // arrange
        int expected = unitPriceCents;
        if(unitPriceCents < 10000) expected += 1200;

        Order order = new Order();
        order.addLine(new OrderLine("item1", 1, unitPriceCents))
                .firstTimeBuyer(false)
                .fragile(false);

        // act
        var price = svc.price(order);

        assertEquals(expected, price);
    }

    @Test
    @DisplayName("discount cap at 25% of subtotal")
    void discountCap() {
        // arrange
        List<OrderLine> orderLines = IntStream.rangeClosed(1, 11)
                .mapToObj(i -> new OrderLine("item" + i, 1, 1)) // 11 items, each 1 cent
                .toList();

        Order order = new Order();
        order.firstTimeBuyer(true);
        order.fragile(false);
        orderLines.forEach(order::addLine);

        // act
        var price = svc.price(order);

        // assert
        assertEquals(1209, price); // 11 subtotal - 2 capped discount + 1200 shipping
    }


    @Test
    @DisplayName("fragile surcharge applies")
    void fragileSurcharge() {
        // arrange
        Order order = new Order();
        order.addLine(new OrderLine("item1", 1, 1))
                .firstTimeBuyer(false)
                .fragile(true);

        // act
        var price = svc.price(order);

        // assert
        assertEquals(1701, price); // 1 price + 1200 shipment + 500 fragile
    }
}
