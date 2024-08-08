package jpredmon;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    public static void main(String[] args) {
        // Check if the required arguments are provided
        if (args.length < 3) {
            System.out.println("Usage: java EmailSender <recipient> <subject> <body>");
            return;
        }

        // Get parameters from the command line
        String recipient = args[0];
        String subject = args[1];
        String body = args[2];

        // Replace with your email credentials
        String username = "";
        String password = "";

        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(username, password, recipient, subject, body);
    }

    public void sendEmail(String username, String password, String recipient, String subject, String body) {
        // SMTP server information for Outlook
        System.out.println("Preparing to send email...");
        String host = "smtp.office365.com"; // Use smtp-mail.outlook.com for some accounts

        // Set properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587"); // Port for TLS
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Get the Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(username));

            // Set To: header field
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: header field
            message.setSubject(subject);

            // Set the actual message
            message.setText(body);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            System.err.println("Error sending email.");
            mex.printStackTrace();
        }
    }
}
