package lab4;

import java.util.Objects;

public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.notificationService = Objects.requireNonNull(notificationService);
    }

    public User register(String username, String email) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username is required");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("email invalid");
        }
        var existing = userRepository.findByUsername(username);
        if (existing.isPresent()) {
            throw new IllegalStateException("duplicate user");
        }
        User toSave = new User(username, email);
        User saved = userRepository.save(toSave);
        notificationService.notifyUser(saved.getUsername());
        return saved;
    }
}
