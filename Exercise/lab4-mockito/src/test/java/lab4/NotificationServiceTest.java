package lab4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Student skeleton – fill in stubbing and verifications for NotificationService.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("NotificationService.notifyUser – email is sent with correct details")
class NotificationServiceTest {

    @Mock UserRepository userRepository;
    @Mock EmailSender emailSender;

    @InjectMocks NotificationService notificationService;

    @Test
    @DisplayName("happy path: looks up user and sends email")
    void notifyUser_happyPath_sendsEmail() {
        // TODO: stub userRepository.findByUsername("john") to return User("john", "john@example.com")
        // TODO: call notificationService.notifyUser("john")
        // TODO: verify emailSender.send was called once
        // TODO: capture subject/body and assert subject contains "Welcome" and body contains "john"

        throw new UnsupportedOperationException("Implement happy path with captor & verification");
    }

    @Test
    @DisplayName("user missing: throws")
    void notifyUser_missingUser_throws() {
        // TODO: stub repository to return empty
        // TODO: assert IllegalArgumentException
        // TODO: verify emailSender.send never called

        throw new UnsupportedOperationException("Implement missing user scenario");
    }
}
