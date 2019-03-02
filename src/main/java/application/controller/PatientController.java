package application.controller;


import application.datastructure.AppointmentForm;
import application.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.*;
import application.model.Booking;
import application.model.Appointment;
import application.model.Patient;

import java.util.Collection;


@Controller
@SessionAttributes(value = "user")
public class PatientController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add_to_cart")
    public String add(@ModelAttribute AppointmentForm appointmentForm, Model model){
        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");
    	this.appointmentService.addAppointmentToCart(patient, appointmentForm);
        return "appointment";
    }
    
    @RequestMapping(value="/removeFromCart", method= RequestMethod.GET)
    public String remove(@RequestParam Appointment appointment, Patient patient){
        this.appointmentService.removeAppointmentFromCart(patient, appointment);
        return "home";
    }

    @RequestMapping(value="/persistAppointment", method= RequestMethod.GET)
    public String save(@RequestParam Appointment appointment){
    	this.appointmentService.saveAppointment(appointment);
        return "home";
    }

    @RequestMapping(value="/checkout", method= RequestMethod.GET)
    public String checkout(@RequestParam Appointment appointment, Patient patient){
    	this.appointmentService.checkoutAppointment(patient, appointment);
        return "checkout";
    }
    
    @RequestMapping(value="/cancelAppointment", method= RequestMethod.GET)
    public String cancel(@RequestParam Booking booking) {
        this.appointmentService.cancelBooking(booking);
    	return "home";
    }

    @RequestMapping(value="/showBookings", method= RequestMethod.GET)
    public String showBookings(Patient patient, Model model) {
        Collection bookings = this.appointmentService.getBookings(patient);
        model.addAttribute("bookings", bookings);
        return "bookings";
    }

}
