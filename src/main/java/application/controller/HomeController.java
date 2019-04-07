package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"user", "appointments", "notification", "notifications"})
public class HomeController {
    @GetMapping("/")
    public String homepage() {
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

    @GetMapping("/Outremont")
    public String homeOutremont() {
        return "home";
    }

    @GetMapping("/Westmount")
    public String homeWestmount() {
        return "home";
    }

    @GetMapping("/Mont-Royal")
    public String homeMontRoyal() {
        return "home";
    }
}
