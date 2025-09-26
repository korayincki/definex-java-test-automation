package lab4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("NotificationService.notifyUser – interaction tests (solutions)")
class NotificationServiceTest {

    @Mock UserRepository userRepository;
    @Mock EmailSender emailSender;

    @InjectMocks NotificationService notificationService;

    @Test
    @DisplayName("happy path: looks up user and sends email with welcome subject and username in body")
    void notifyUser_happyPath_sendsEmail() {
        when(userRepository.findByUsername("john"))
            .thenReturn(Optional.of(new User("john", "john@example.com")));

        notificationService.notifyUser("john");

        ArgumentCaptor<String> to = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> subject = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> body = ArgumentCaptor.forClass(String.class);

        verify(emailSender, times(1)).send(to.capture(), subject.capture(), body.capture());

        assertEquals("john@example.com", to.getValue());
        assertTrue(subject.getValue().contains("Welcome"));
        assertTrue(body.getValue().toLowerCase().contains("john"));
    }

    @Test
    @DisplayName("missing user: throws and never sends")
    void notifyUser_missingUser_throws() {
        when(userRepository.findByUsername("ghost")).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> notificationService.notifyUser("ghost"));

        verify(emailSender, never()).send(anyString(), anyString(), anyString());
    }
}
