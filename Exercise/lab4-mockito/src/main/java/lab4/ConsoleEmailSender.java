package lab4;

public class ConsoleEmailSender implements EmailSender {
    @Override
    public void send(String to, String subject, String body) {
        System.out.printf("EMAIL -> to=%s, subject=%s, body=%s%n", to, subject, body);
    }
}
