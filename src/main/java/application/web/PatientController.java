package application.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    @GetMapping("/appointment")
    public String appointmentPage(){
        return "appointment";
    }

    @PostMapping("/appointment")
    public String processAppointment(@RequestParam String appointment_type,
                                     @RequestParam String date,
                                     @RequestParam String time,
                                     @RequestParam String description,
                                     Model model){

        //Appointment appointment = new Appointment(appointment_type, date, time, description);
        //model.addAttribute("cart", cart); <-- should add the cart fragment to homepage
        return "home";
    }

}
