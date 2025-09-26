package lab4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

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

    @BeforeEach void setUp() { }

    @AfterEach void tearDown() { }

    @Test
    @DisplayName("happy path: saves & notifies")
    void register_happyPath_savesAndNotifies() {
        // TODO: stub repo.findByUsername to return empty and repo.save to return a User
        // TODO: call userService.register("john", "john@example.com")
        // TODO: verify repo.save called with User('john', 'john@example.com')
        // TODO: capture notify username via ArgumentCaptor and verify notifyUser('john')

        throw new UnsupportedOperationException("Implement happy path with stubbing & verification");
    }

    @Test
    @DisplayName("duplicate username: throws and no save/notify")
    void register_duplicate_throws_noInteractions() {
        // TODO: stub findByUsername to return an existing user
        // TODO: assert that register throws IllegalStateException
        // TODO: verify save(...) never called; verify notifyUser(...) never called

        throw new UnsupportedOperationException("Implement duplicate user scenario");
    }

    @Test
    @DisplayName("invalid input: throws and no save/notify")
    void register_invalidInput_throws_andNoSave() {
        // Example invalid email
        // TODO: assert that register('bad', 'not-an-email') throws IllegalArgumentException
        // TODO: verify no interactions with save/notify

        throw new UnsupportedOperationException("Implement invalid input scenario");
    }
}
