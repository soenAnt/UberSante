package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = "user")
public class HomeController {
    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    @GetMapping("/appointment_page")
    public String appointmentPage(){
        return "appointment";
    }
}
