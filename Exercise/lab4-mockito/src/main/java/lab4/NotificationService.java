package lab4;

import java.util.Locale;

public class NotificationService {

    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public NotificationService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void notifyUser(String username) {
        var userOpt = userRepository.findByUsername(username);
        var user = userOpt.orElseThrow(() -> new IllegalArgumentException("user not found"));
        String subject = "Welcome";
        String body = "Hello " + username.toLowerCase(Locale.ROOT);
        emailSender.send(user.getEmail(), subject, body);
    }
}
