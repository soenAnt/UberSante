package application.controller;

import application.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"user", "appointments", "notification", "notifications"})
public class HomeController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/")
    public String homepage() {
        this.clinicService.updateAll();
        return "home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/appointment_page")
    public String appointmentPage(){
        return "appointment";
    }

    @GetMapping("/booking")
    public String bookingPage(){
        return "booking";
    }

    @GetMapping("/contact")
    public String contactus(){
        return "contact";
    }

    @GetMapping("/about")
    public String aboutus(){
        return "about";
    }
}
