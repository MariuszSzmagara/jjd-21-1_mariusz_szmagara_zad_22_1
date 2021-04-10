package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.model.MailMessage;
import pl.javastart.service.MailService;

@Controller
public class MailController {
    private MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/sendContactMailMessage")
    public String sendContactMailMessage(MailMessage mailMessage) {
        mailService.sendMail(mailMessage);
        return "success";
    }
}
