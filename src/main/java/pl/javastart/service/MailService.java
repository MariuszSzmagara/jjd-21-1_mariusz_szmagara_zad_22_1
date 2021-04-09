package pl.javastart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.javastart.model.MailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class MailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String receiver;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(MailMessage mailMessage) {
        LOGGER.debug("Sending maila to {} ", receiver);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(mailMessage.getTextContent(), true);
            helper.setFrom(mailMessage.getPerson().getEmailAddress(),
                    (mailMessage.getPerson().getFirstName() + " " + mailMessage.getPerson().getLastName()));
            helper.setReplyTo(mailMessage.getPerson().getEmailAddress());
            helper.setCc(mailMessage.getPerson().getEmailAddress());
            helper.setTo(receiver);
            helper.setSubject(mailMessage.getSubject());
            javaMailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException exception) {
            exception.printStackTrace();
            LOGGER.warn("Error sending mail", exception);
        }
        LOGGER.debug("Mail to {} has been sent successfully!", receiver);
    }
}
