package application.controller;


import application.datastructure.AppointmentForm;
import application.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import application.model.Booking;
import application.model.Appointment;
import application.model.Patient;

import java.util.Collection;


@Controller
public class PatientController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointment")
    public String appointmentPage(){
        return "appointment";
    }

    @PostMapping("/appointment")
    public String add(@ModelAttribute AppointmentForm appointmentForm, Patient patient){
    	this.appointmentService.addAppointmentToCart(patient, appointmentForm);
        return "home";
    }
    
    @RequestMapping(value="/removeFromCart", method= RequestMethod.GET)
    public String remove(@RequestParam Appointment appointment, Patient patient){
        this.appointmentService.removeAppointmentFromCart(patient, appointment);
        return "/";
    }

    @RequestMapping(value="/persistAppointment", method= RequestMethod.GET)
    public String save(@RequestParam Appointment appointment){
    	this.appointmentService.saveAppointment(appointment);
        return "/";
    }

    @RequestMapping(value="/checkout", method= RequestMethod.GET)
    public String checkout(@RequestParam Appointment appointment, Patient patient){
    	this.appointmentService.checkoutAppointment(patient, appointment);
        return "checkout";
    }
    
    @RequestMapping(value="/cancelAppointment", method= RequestMethod.GET)
    public String cancel(@RequestParam Booking booking) {
        this.appointmentService.cancelBooking(booking);
    	return "/";
    }

    @RequestMapping(value="/showBookings", method= RequestMethod.GET)
    public String showBookings(Patient patient, Model model) {
        Collection bookings = this.appointmentService.getBookings(patient);
        model.addAttribute("bookings", bookings);
        return "/bookings";
    }

}
