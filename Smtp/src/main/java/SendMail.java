import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by suren on 03/02/2018.
 */
public class SendMail {

    public static void send(final Properties props) {

        String from = props.getProperty("testmail.from");
        String to = props.getProperty("testmail.to");
        String subject = props.getProperty("testmail.subject");
        String body = props.getProperty("testmail.body");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(props.getProperty("mail.user"), props.getProperty("mail.password"));
                    }
                });
        Message simpleMessage = new MimeMessage(mailSession);

        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
        try {
            fromAddress = new InternetAddress(from);
            toAddress = new InternetAddress(to);
        } catch (AddressException e) {
            e.printStackTrace();
        }

        try {
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipient(MimeMessage.RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);
            simpleMessage.setText(body);

            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            System.err.println("Error sending mail");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Properties props = new Properties();
        try {
            props.load(new FileInputStream("src/main/resources/sample_mail.properties"));
        } catch (FileNotFoundException e1) {
            System.err.println("Properties file not found");
            e1.printStackTrace();
        } catch (IOException e1) {
            System.err.println("Error loading properties file");
            e1.printStackTrace();
        }

        SendMail.send(props);
    }
}
