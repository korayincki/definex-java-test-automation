package lab4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

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
        //arrange
        when(userRepository.findByUsername("john")).thenReturn(Optional.of(new User("john", "john@example.com")));

        //act
        notificationService.notifyUser("john");
        ArgumentCaptor<String> subjectCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);     
         
        //assert
        verify(emailSender, times(1)).send(anyString(), subjectCaptor.capture(), bodyCaptor.capture());
        assertEquals("Welcome", subjectCaptor.getValue());
        assertEquals("Hello john", bodyCaptor.getValue());
        //throw new UnsupportedOperationException("Implement happy path with captor & verification");
    }

    @Test
    @DisplayName("user missing: throws")
    void notifyUser_missingUser_throws() {
        // TODO: stub repository to return empty
        // TODO: assert IllegalArgumentException
        // TODO: verify emailSender.send never called
        when(userRepository.findByUsername(null)).thenReturn(Optional.empty());
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            notificationService.notifyUser(null);
        });
        verify(emailSender, times(0)).send(anyString(), anyString(), anyString());

        //throw new UnsupportedOperationException("Implement missing user scenario");
    }
}
