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
    
    @RequestMapping(value="/removeFromCart", method= RequestMethod.GET)
    public String removeFromCart(@RequestParam(value="appointmentId", required = true) int id){
        // remove appointment from cart
        return "";
    }

    @RequestMapping(value="/persistAppointment", method= RequestMethod.GET)
    public String persistAppointment(@RequestParam(value="appointmentId", required = true) int id){
        // persist the appointment in table appointment_info
        return "";
    }

    @RequestMapping(value="/checkout", method= RequestMethod.GET)
    public String checkout(@RequestParam(value="appointmentId", required = true) int id){
 		// redirect to checkout page -> payment page (Matthew)
		// persist the appointment in table appointments
        return "";
    }

}
