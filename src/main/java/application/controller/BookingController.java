package application.controller;

import application.datastructure.AppointmentForm;
import application.datastructure.BookingAddForm;
import application.datastructure.BookingUpdateForm;
import application.model.*;
import application.repository.UserRepository;
import application.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@SessionAttributes(value = {"user", "appointments", "patient", "doctor", "notification", "notifications"})
public class BookingController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingService bookingService;

    private Collection<User> doctorList;
    private Booking updateBooking;
    private User updatePatient;
    private int bookingUpdateId;

    @RequestMapping("/showBookings")
    public String showBookings(Model model){

        User user = (User) ((BindingAwareModelMap) model).get("user");

        Collection<Booking> bookings = this.bookingService.getBookings(user);

        model.addAttribute("bookings", bookings);

        return "booking";
    }

    @RequestMapping("/booking/home")
    public String homePageBookings(Model model){
        User user = (User) ((BindingAwareModelMap) model).get("user");
        model.addAttribute("user", user);
        return "home";
    }
    @RequestMapping("/addBooking")
    public String addBookings(Model model){

        User user = (User) ((BindingAwareModelMap) model).get("user");

        model.addAttribute("user", user);
        doctorList = bookingService.getDoctorList();
        model.addAttribute("doctorList", doctorList);
        //model.addAttribute("user", user);
        model.addAttribute("appear","appear");

        return "booking_add_update";
    }
    @RequestMapping("/updateBookingPage")
    public String bookingUpdate(@RequestParam(value="id") int id, Model model){
        User user = (User) ((BindingAwareModelMap) model).get("user");
        doctorList = bookingService.getDoctorList();
        bookingUpdateId = id;
        updateBooking = bookingService.getbooking(id);
        updatePatient = bookingService.getPatient(updateBooking.getPatient().getUserId());
        model.addAttribute("user",user);
        model.addAttribute("patientUpdate", updatePatient);
        model.addAttribute("doctorList", doctorList);
        model.addAttribute("booking",updateBooking);

        return "booking_add_update";
    }
    @RequestMapping(value="/updateBooking/validate", method= RequestMethod.POST)
    public String bookingUpdateValidate(@ModelAttribute BookingUpdateForm bookingUpdateForm, Model model){
        User user = (User) ((BindingAwareModelMap) model).get("user");

        boolean validate = bookingService.updateValidate_Save(user, bookingUpdateForm, updateBooking);
        model.addAttribute("user", user);
        if(validate) {
            return "home";
        }
        else{
            doctorList = bookingService.getDoctorList();
            updateBooking = bookingService.getbooking(bookingUpdateId);
            updatePatient = bookingService.getPatient(updateBooking.getPatient().getUserId());
            model.addAttribute("patientUpdate", updatePatient);
            model.addAttribute("doctorList", doctorList);
            model.addAttribute("booking",updateBooking);
            model.addAttribute("error","error");
            return "booking_add_update";
        }
    }
    @RequestMapping(value="/addBooking/validate", method= RequestMethod.POST)
    public String addBookingValidate(@ModelAttribute BookingAddForm bookingAddForm, Model model){

        User user = (User) ((BindingAwareModelMap) model).get("user");

        boolean validate = bookingService.createValidate_Save(user, bookingAddForm);
        model.addAttribute("user", user);
        doctorList = bookingService.getDoctorList();
        model.addAttribute("doctorList", doctorList);
        model.addAttribute("appear","appear");
        if(validate){

            model.addAttribute("success","success");
        }
        else{

            model.addAttribute("error","error");
        }

        return "booking_add_update";
    }

    @RequestMapping("/updateBooking")
    public String update(@RequestParam String date, 
                         @RequestParam String time,
                         @RequestParam String booking_type,
                         @RequestParam String description,
                         @RequestParam Doctor doctor,
                         @RequestParam int room,
                         @RequestParam(value="id") int id, Model model){

        Patient patient = (Patient) ((BindingAwareModelMap) model).get("patient");
        Appointment appointment = retrieveAppointment(id, model);
        Booking booking = retrieveBooking(id, model);

        Collection<Booking> bookings = this.bookingService.updateBooking(patient, doctor, booking, appointment, room);

        model.addAttribute("bookings", bookings);
 
        return "booking";
    } 

    @RequestMapping(value="/removeBooking", method= RequestMethod.GET)
    public String cancel(@RequestParam(value="id") int booking_id, Model model){

        this.bookingService.cancelBooking(booking_id);

        User user = (User) ((BindingAwareModelMap) model).get("user");

        Collection<Booking> bookings = this.bookingService.getBookings(user);

        model.addAttribute("bookings", bookings);
        model.addAttribute("user", user);
        return "booking";
    }

    @RequestMapping(value="/followUp", method= RequestMethod.GET)
    public String followUpPage(@RequestParam(value="id") int patient_id, Model model){
        Patient patient = this.bookingService.getPatient(patient_id);
        Doctor doctor = (Doctor) ((BindingAwareModelMap) model).get("user");
        
        model.addAttribute("patient", patient);
        model.addAttribute("user", doctor);
        
        return "appointment";
    }

    @PostMapping("/follow_up")
    public String followUpBooking(@ModelAttribute AppointmentForm appointmentForm, Patient patient, Doctor doctor){

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
