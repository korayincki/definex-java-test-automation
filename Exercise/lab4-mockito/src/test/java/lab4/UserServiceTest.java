package lab4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * Student skeleton – fill in stubbing and verifications.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("UserService.register – interaction tests")
class UserServiceTest {

    @Mock UserRepository userRepository;
    @Mock NotificationService notificationService;

    @InjectMocks UserService userService;

    private String USERNAME = "test";
    private String EMAIL = "test@test.com";

    @BeforeEach void setUp() { }

    @AfterEach void tearDown() { }

    @Test
    @DisplayName("happy path: saves & notifies")
    void register_happyPath_savesAndNotifies() {
        // TODO: stub repo.findByUsername to return empty and repo.save to return a User
        // TODO: call userService.register("john", "john@example.com")
        // TODO: verify repo.save called with User('john', 'john@example.com')
        // TODO: capture notify username via ArgumentCaptor and verify notifyUser('john')

        // arrange
        when(userRepository.findByUsername(any()))
                .thenReturn(Optional.empty());

        when(userRepository.save(any(User.class)))
                .thenReturn(new User(USERNAME, EMAIL));

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        // act
        userService.register(USERNAME, EMAIL);

        // assert
        verify(userRepository, times(1)).save(any(User.class));
        verify(userRepository, times(1)).save(userCaptor.capture());
        verify(notificationService, times(1)).notifyUser(userCaptor.getValue().getUsername());
    }

    @Test
    @DisplayName("duplicate username: throws and no save/notify")
    void register_duplicate_throws_noInteractions() {
        // TODO: stub findByUsername to return an existing user
        // TODO: assert that register throws IllegalStateException
        // TODO: verify save(...) never called; verify notifyUser(...) never called

        // arrange
        when(userRepository.findByUsername(any()))
                .thenReturn(Optional.of(new User(USERNAME, EMAIL)));

        // act
        Runnable register = () -> userService.register(USERNAME, EMAIL);

        // assert
        Assertions.assertThrows(IllegalStateException.class, register::run);

        verify(userRepository, never()).save(any(User.class));
        verify(notificationService, never()).notifyUser(any(String.class));
    }

    @Test
    @DisplayName("invalid input: throws and no save/notify")
    void register_invalidInput_throws_andNoSave() {
        // Example invalid email
        // TODO: assert that register('bad', 'not-an-email') throws IllegalArgumentException
        // TODO: verify no interactions with save/notify

        // act
        Runnable register = () -> userService.register("bad", "not-an-email");

        // assert
        Assertions.assertThrows(IllegalArgumentException.class, register::run);
        verify(userRepository, never()).save(any(User.class));
        verify(notificationService, never()).notifyUser(any(String.class));
    }
}
