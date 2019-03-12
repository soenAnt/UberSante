package application.controller;

import application.datastructure.AppointmentForm;
import application.model.Appointment;
import application.model.Booking;
import application.model.Doctor;
import application.model.Patient;
import application.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@SessionAttributes(value = {"user", "appointments"})

public class BookingController {


    @Autowired
    private BookingService bookingService;


    @RequestMapping("/updateBooking")
    public String update(@RequestParam String date, 
                         @RequestParam String time,
                         @RequestParam String booking_type,
                         @RequestParam String description,
                         @RequestParam Doctor doctor,
                         @RequestParam int room,
                         @RequestParam int id,
                         @RequestParam String uuid, Model model){

        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");
        Appointment appointment = retrieveAppointment(id, model);
        Booking booking = retrieveBooking(id, model);

        Collection<Booking> bookings = this.bookingService.updateBooking(patient, doctor, booking, appointment, room);

        model.addAttribute("bookings", bookings);
 
        return "booking";
    } 

    @RequestMapping(value="/cancelBooking", method= RequestMethod.GET)
    public String cancel(@RequestParam Booking booking, Model model){

        this.bookingService.cancelBooking(booking);

        return "booking";
    }

    @RequestMapping(value="/followUp", method= RequestMethod.GET)
    public String followUpPage(@RequestParam(value="id") int patient_id, Model model){
        Patient patient = this.bookingService.getPatient(patient_id);
        Doctor doctor = (Doctor) ((BindingAwareModelMap) model).get("user");
        
        model.addAttribute("patient", patient);
        model.addAttribute("doctor", doctor);
        
        return "appointment";
    }

    @PostMapping("/followUpBooking")
    public String followUpBooking(@ModelAttribute AppointmentForm appointmentForm, Model model){
        Patient patient = (Patient) ((BindingAwareModelMap) model).get("patient");
        Doctor doctor = (Doctor) ((BindingAwareModelMap) model).get("user");
        
        this.bookingService.followUp(doctor, patient, appointmentForm);
        
        return "home";
    }

    private Appointment retrieveAppointment(int id, Model model){

        return getAppointment(id, (BindingAwareModelMap) model);
    }

    private Booking retrieveBooking(int id, Model model){

        return getBooking(id, (BindingAwareModelMap) model);
    }

    static Appointment getAppointment(int id, BindingAwareModelMap model) {
        Patient patient = (Patient) model.get("user");

        ArrayList<Appointment> appointments = patient.getCart().getAppointments();

        for(Appointment appointment : appointments){

            if(appointment.getAppointmentId() == id)

                return appointment;
        }

        return null;
    }

    static Booking getBooking(int id, BindingAwareModelMap model) {

        Patient patient = (Patient) model.get("user");

        Collection<Booking> bookings = patient.getBookings();

        for(Booking booking : bookings){

            if(booking.getBookingId() == id)

                return booking;
        }

        return null;
    }
}
