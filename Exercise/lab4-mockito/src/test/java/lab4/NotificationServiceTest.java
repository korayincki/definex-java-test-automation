package lab4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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

        // arrange
        when(userRepository.findByUsername("john"))
                .thenReturn(Optional.of(new User("john", "john@example.com")));

        ArgumentCaptor<String> subjectCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);

        // act
        notificationService.notifyUser("john");

        // assert
        verify(emailSender).send(eq("john@example.com"), subjectCaptor.capture(), bodyCaptor.capture());

        String capturedSubject = subjectCaptor.getValue();
        String capturedBody = bodyCaptor.getValue();

        Assertions.assertTrue(capturedSubject.contains("Welcome"));
        Assertions.assertTrue(capturedBody.contains("john"));
    }

    @Test
    @DisplayName("user missing: throws")
    void notifyUser_missingUser_throws() {
        // TODO: stub repository to return empty
        // TODO: assert IllegalArgumentException
        // TODO: verify emailSender.send never called

        // arrange
        when(userRepository.findByUsername(any()))
                .thenReturn(Optional.empty());

        // act
        Runnable notify = () -> notificationService.notifyUser("john");

        // assert
        Assertions.assertThrows(IllegalArgumentException.class, notify::run);

        verify(emailSender, never()).send(any(), any(), any());
    }
}
