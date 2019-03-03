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

import java.util.ArrayList;
import java.util.Collection;


@Controller
@SessionAttributes(value = {"user", "appointments"})
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add_to_cart")
    public String add(@ModelAttribute AppointmentForm appointmentForm, Model model){

        Patient patient = setupModel(model);

        this.appointmentService.addAppointmentToCart(patient, appointmentForm);

        return "home";
    }

    @PostMapping("/update_to_cart")
    public String updatePersisted(@RequestParam String date,
                                  @RequestParam String time,
                                  @RequestParam String appointment_type,
                                  @RequestParam String description,
                                  @RequestParam int id,
                                  @RequestParam String uuid, Model model){

        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");
        Appointment appointment = null;

        if(id != 0){
            appointment = retrievePersistedAppointment(id, model);
        }
        else {
            appointment = retrieveNonPersistedAppointment(uuid, model);
        }

        ArrayList<Appointment> appointments = this.appointmentService.updateAppointment(patient,
                appointment, date, time, description, appointment_type);

        model.addAttribute("appointments", appointments);

        return "home";
    }

    @RequestMapping(value="/removeAppointment", method= RequestMethod.GET)
    public String remove(@RequestParam(value="id") int appointment_id, Model model){

        Patient patient = setupModel(model);

        Appointment appointment = retrievePersistedAppointment(appointment_id, model);

        this.appointmentService.removeAppointmentFromCart(patient, appointment);

        return "home";
    }

    @RequestMapping(value="/persistAppointment", method= RequestMethod.GET)
    public String save(@RequestParam(value="id") String uuid, Model model){

        Appointment appointment = retrieveNonPersistedAppointment(uuid, model);

        this.appointmentService.saveAppointment(appointment);

        return "home";
    }

    @RequestMapping(value="/updateNonPersistedAppointment", method= RequestMethod.GET)
    public String updateNonPersistedForm(@RequestParam(value="id") String uuid, Model model){

        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");

        Appointment appointment = retrieveNonPersistedAppointment(uuid, model);

        model.addAttribute("user", patient);
        model.addAttribute("appointment", appointment);
        //this.appointmentService.updateAppointment(patient, appointment);

        return "updateAppointment";
    }

    @RequestMapping(value="/updatePersistedAppointment", method= RequestMethod.GET)
    public String updatePersistedForm(@RequestParam(value="id") int id, Model model){

        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");

        Appointment appointment = retrievePersistedAppointment(id, model);

        model.addAttribute("user", patient);
        model.addAttribute("appointment", appointment);
        //this.appointmentService.updateAppointment(patient, appointment);

        return "updateAppointment";
    }

    @RequestMapping(value="/checkout", method= RequestMethod.GET)
    public String checkout(@RequestParam(value="id") int appointment_id, Model model){

        Patient patient = setupModel(model);

        Appointment appointment = retrievePersistedAppointment(appointment_id, model);

        this.appointmentService.checkoutAppointment(patient, appointment);

        return "checkout";
    }
    
    @RequestMapping(value="/cancelAppointment", method= RequestMethod.GET)
    public String cancel(@RequestParam Booking booking, Model model) {

        this.appointmentService.cancelBooking(booking);

        return "home";
    }

    @RequestMapping(value="/showBookings", method= RequestMethod.GET)
    public String showBookings(Patient patient, Model model) {

        Collection bookings = this.appointmentService.getBookings(patient);

        model.addAttribute("bookings", bookings);

        return "bookings";
    }

    // sets up boiler-plate code for each requested mapping
    private Patient setupModel(Model model){

        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");

        ArrayList<Appointment> appointments = patient.getCart().getAppointments();

        model.addAttribute("user", patient);

        model.addAttribute("appointments", appointments);

        return patient;
    }

    // returns a persisted appointment from cart
    private Appointment retrievePersistedAppointment(int id, Model model){

        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");

        ArrayList<Appointment> appointments = patient.getCart().getAppointments();

        for(Appointment appointment : appointments){

            if(appointment.getAppointmentId() == id)

                return appointment;
        }

        return null;
    }

    // returns a non-persisted appointment from cart using uuid instead of yet-to-be-generated appointment_id
    private Appointment retrieveNonPersistedAppointment(String uuid, Model model){

        Patient patient = (Patient) ((BindingAwareModelMap) model).get("user");

        ArrayList<Appointment> appointments = patient.getCart().getAppointments();

        for(Appointment appointment : appointments){

            if(appointment.getAppointmentId() == 0)

                if(appointment.getUuid().equals(uuid))

                    return appointment;
        }

        return null;
    }

}
