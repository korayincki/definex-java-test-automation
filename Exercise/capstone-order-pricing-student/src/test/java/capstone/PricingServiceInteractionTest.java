package capstone;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/**
 * Student skeleton – verify interaction with OrderValidator.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("PricingService interaction tests (student skeleton)")
class PricingServiceInteractionTest {

    @Mock OrderValidator validator;
    PricingService svc;

    @BeforeEach
    void setUp() {
        svc = new PricingService(validator);
    }

    @Test
    @DisplayName("validator is called once on happy path")
    void validatorCalledOnce() {
        // Arrange: validator does nothing
        doNothing().when(validator).validate(any(Order.class));
        Order order = new Order();
        order.addLine(new OrderLine("item1", 1, 1000))
                .firstTimeBuyer(false)
                .fragile(false);

        // Act: price a simple order
        var price = svc.price(order);

        // Assert: verify(validator, times(1)).validate(order);
        verify(validator, times(1)).validate(order);
    }

    @Test
    @DisplayName("validator throws -> pricing does not proceed")
    void validatorThrows_haltingCalculation() {
        // Arrange: doThrow(new IllegalArgumentException("bad")).when(validator).validate(any())
        doThrow(new IllegalArgumentException("bad")).when(validator).validate(any());
        Order order = new Order();
        order.addLine(new OrderLine("item1", 1, 1000))
                .firstTimeBuyer(false)
                .fragile(false);

        // Act & Assert: assertThrows for price(...)
        Runnable price = () -> svc.price(order);

        // assert
        Assertions.assertThrows(IllegalArgumentException.class, price::run);

        // And verifyNoMoreInteractions(validator) or no interactions on collaborators
        verify(validator).validate(any());
        verifyNoMoreInteractions(validator);
    }
}
