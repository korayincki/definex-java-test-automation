package capstone;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

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
        // Act: price a simple order
        // Assert: verify(validator, times(1)).validate(order);
        throw new UnsupportedOperationException("implement");
    }

    @Test
    @DisplayName("validator throws -> pricing does not proceed")
    void validatorThrows_haltingCalculation() {
        // Arrange: doThrow(new IllegalArgumentException("bad")).when(validator).validate(any())
        // Act & Assert: assertThrows for price(...)
        // And verifyNoMoreInteractions(validator) or no interactions on collaborators
        throw new UnsupportedOperationException("implement");
    }
}
