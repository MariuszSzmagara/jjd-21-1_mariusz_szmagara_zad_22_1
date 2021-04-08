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
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);
    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(MailMessage mailMessage) {
        String receiver = "javastart.pl.homework@gmail.com";
        logger.debug("Wysyłam maila do {} ", receiver);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(mailMessage.getTextContent(), true);
            helper.setFrom(mailMessage.getContactPersonMailAddress(),
                    (mailMessage.getContactPersonFirstName() + " " + mailMessage.getContactPersonLastName()));
            helper.setReplyTo(mailMessage.getContactPersonMailAddress());
            helper.setCc(mailMessage.getContactPersonMailAddress());
            helper.setTo(receiver);
            helper.setSubject(mailMessage.getSubject());
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException exception) {
            exception.printStackTrace();
            logger.warn("Błąd podczas wysyłania wiadomości ", exception);
        }
        logger.debug("Maila do {} wysłany poprawnie", receiver);
    }
}
