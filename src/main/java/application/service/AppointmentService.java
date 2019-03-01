package application.service;

import application.datastructure.AppointmentForm;
import application.model.Appointment;
import application.model.Booking;
import application.model.Doctor;
import application.model.Patient;
import application.repository.BookingRepository;
import application.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    /*
     * If cart has not been initialized, create it and populate with persisted appointments.
     */
    private void initCart(Patient patient) {
        Collection<Appointment> collected = this.appointmentRepository.findByPatient(patient);
        patient.getCart().setAppointments(new ArrayList<>(collected));
    }

    /*
     * Appointment is added to cart without being persisted
     */
    public void addAppointmentToCart(Patient patient, AppointmentForm appointmentForm) {

        if(!patient.getHasCart()){
            initCart(patient);
            patient.setHasCart(true);
        }

        Appointment appointment = new Appointment(patient, stringToDate(appointmentForm.getDate()),
                stringToTime(appointmentForm.getTime()), appointmentForm.getAppointment_type(),
                appointmentForm.getDescription());

        patient.getCart().addAppointment(appointment);

    }

    /*
     * Retrieve appointments in cart to be displayed to client
     */
    public ArrayList<Appointment> getAppointmentsFromCart(Patient patient){

        return patient.getCart().getAppointments();
    }

    /*
     * Appointment added to appointments table and remains in cart
     */
    public void saveAppointment(Appointment appointment){

        this.appointmentRepository.save(appointment);
    }

    /*
     * Appointment removed from cart. If it exists in the database, it will be removed from there too.
     */
    public void removeAppointmentFromCart(Patient patient, Appointment appointment){

        patient.getCart().removeAppointment(appointment);

        this.appointmentRepository.delete(appointment);
    }

    /*
     * Checking if appointment is already pesisted in database. If not, it is saved and retrieved with its Id.
     * Booking object instantiated with the patient, doctor, room and appoitment and then created in database.
     * Booked appointment now removed from cart after checkout.
     * TODO refactor checkoutAppointment() to save booking ONLY after payment is made.
     */
    public void checkoutAppointment(Patient patient, Appointment appointment){

        Boolean exists = this.appointmentRepository.exists(appointment.getAppointmentId());

        if(!exists){
            appointment = this.appointmentRepository.saveAndFlush(appointment);
        }

        Doctor doctor = getAvailableDoctor(appointment);

        int room = getAvailableRoom(appointment);

        Booking booking = new Booking(doctor, patient, appointment, room);

        this.bookingRepository.save(booking);

        patient.getCart().removeAppointment(appointment);
    }

    /*
     * TODO feature 4: system must find an available doctor for the specified date-time
     */
    private Doctor getAvailableDoctor(Appointment appointment) {

        Doctor doctor = new Doctor(); // query db to find available doctor

        return doctor;
    }

    /*
     * TODO feature 4: system must find an available room for the specified date-time
     */
    private int getAvailableRoom(Appointment appointment) {

        return 1;
    }

    /*
     * Patient's booked appointments to be displayed on booking.html
     */
    public Collection<Booking> getBookings(Patient patient){

        Collection<Booking> bookings = this.bookingRepository.findByPatient(patient);

        if(bookings.isEmpty()){
            System.out.println("You do not have any appointments booked.");
            return bookings;
        }

        return bookings;
    }

    /*
     * Patient cancels an appointment from booking.html
     */
    public void cancelBooking(Booking booking) {
        this.bookingRepository.delete(booking);
    }

    /*
     * Handle string conversion to time
     */
    private Time stringToTime(String string_time) {

        SimpleDateFormat sdf = new SimpleDateFormat(string_time);

        long ms = 0;

        try {
            ms = sdf.parse(string_time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Time time = new Time(ms);

        return time;
    }
    /*
     * Handle string conversion to date
     */
    private Date stringToDate(String string_date) {

        Date date = null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(string_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}