package pl.javastart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.javastart.model.MailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class MailService {
    private final JavaMailSender javaMailSender;
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(MailMessage mailMessage) {
        logger.debug("Wysyłam maila do {} ", "javastart.pl.homework@gmail.com");
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(mailMessage.getTextContent(), true);
            helper.setFrom("javastart.pl.homework@gmail.com", (mailMessage.getReceiverFirstName() + " " + mailMessage.getReceiverLastName()));
            helper.setReplyTo(mailMessage.getEmailAddress());
            helper.setCc(mailMessage.getEmailAddress());
            helper.setTo("javastart.pl.homework@gmail.com");
            helper.setSubject(mailMessage.getSubject());
            helper.setText(mailMessage.getTextContent());
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException exception) {
            exception.printStackTrace();
            logger.warn("Błąd podczas wysyłania wiadomości ", exception);
        }
        logger.debug("Maila do {} wysłany poprawnie", "javastart.pl.homework@gmail.com");
    }
}
