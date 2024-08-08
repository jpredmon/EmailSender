package jpredmon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmailSenderTest {

    @Test
    public void testSendEmail() {
        // Replace with your actual email credentials and recipient
        String username = "";
        String password = "";
        String recipient = "";
        String subject = "Test Subject";
        String body = "This is a test email body.";

        EmailSender emailSender = new EmailSender();

        // Test if the sendEmail method executes without throwing exceptions
        assertDoesNotThrow(() -> {
            emailSender.sendEmail(username, password, recipient, subject, body);
        });
    }
}
