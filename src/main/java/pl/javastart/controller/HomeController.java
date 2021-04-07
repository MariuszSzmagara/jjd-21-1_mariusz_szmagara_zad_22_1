package pl.javastart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.model.MailMessage;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/career")
    public String getRegulamin() {
        return "career";
    }

    @GetMapping("/newMessage")
    public String newMessage(Model model) {
        model.addAttribute("newMessage", new MailMessage());
        return "contactForm";
    }
}
