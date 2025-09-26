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
@DisplayName("UserService.register – interaction tests (solutions)")
class UserServiceTest {

    @Mock UserRepository userRepository;
    @Mock NotificationService notificationService;

    @InjectMocks UserService userService;

    @BeforeEach
    void setUp() { }

    @Test
    @DisplayName("happy path: saves user, then notifies with username")
    void register_happyPath_savesAndNotifies() {
        // Arrange
        when(userRepository.findByUsername("john")).thenReturn(Optional.empty());
        // Let save return its argument
        when(userRepository.save(any(User.class))).thenAnswer(inv -> (User) inv.getArgument(0));

        // Act
        User saved = userService.register("john", "john@example.com");

        // Assert saved user
        assertEquals("john", saved.getUsername());
        assertEquals("john@example.com", saved.getEmail());

        // Capture arguments to save
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(userCaptor.capture());
        User passed = userCaptor.getValue();
        assertEquals("john", passed.getUsername());
        assertEquals("john@example.com", passed.getEmail());

        // Verify notify called with username
        InOrder inOrder = inOrder(userRepository, notificationService);
        inOrder.verify(userRepository).save(any(User.class));
        inOrder.verify(notificationService).notifyUser("john");
        verify(notificationService, times(1)).notifyUser("john");
    }

    @Test
    @DisplayName("duplicate username: throws and no save/notify")
    void register_duplicate_throws_noInteractions() {
        when(userRepository.findByUsername("john")).thenReturn(Optional.of(new User("john", "x@y.com")));

        assertThrows(IllegalStateException.class, () -> userService.register("john", "john@example.com"));

        verify(userRepository, never()).save(any());
        verify(notificationService, never()).notifyUser(any());
    }

    @Test
    @DisplayName("invalid input: throws and no repo/notify interactions")
    void register_invalidInput_throws_andNoSave() {
        assertThrows(IllegalArgumentException.class, () -> userService.register("john", "not-an-email"));
        // No repository nor notification should be touched
        verifyNoInteractions(userRepository, notificationService);
    }
}
