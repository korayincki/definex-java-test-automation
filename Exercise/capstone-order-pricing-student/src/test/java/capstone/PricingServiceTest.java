package capstone;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        throw new UnsupportedOperationException("implement");
    }

    @ParameterizedTest(name = "[{index}] items={0} firstTime={1} expected={2}")
    @CsvSource({
            // TODO: Fill rows: items, firstTimeBuyer, expectedPrice
            // e.g., "2,true,xxxx", "10,true,xxxx", "11,true,xxxx"
    })
    @DisplayName("threshold tests for first-time and bulk rules")
    void thresholdsFirstTimeAndBulk(int items, boolean firstTime, int expected) {
        // Build an order with 'items' quantity of unit price 1000
        // Then assert price equals expected
        throw new UnsupportedOperationException("implement");
    }

    @Test
    @DisplayName("shipping threshold 9_999 / 10_000 / 10_001")
    void shippingThresholds() {
        // Build orders around the shipping free threshold
        throw new UnsupportedOperationException("implement");
    }

    @Test
    @DisplayName("discount cap at 25% of subtotal")
    void discountCap() {
        // Construct an order that would exceed the cap without enforcement
        throw new UnsupportedOperationException("implement");
    }

    @Test
    @DisplayName("fragile surcharge applies")
    void fragileSurcharge() {
        // fragile=true should add +500
        throw new UnsupportedOperationException("implement");
    }
}
