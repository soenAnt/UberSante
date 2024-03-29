package application.service;

import application.datastructure.AppointmentForm;
import application.interfaces.Visitable;
import application.interfaces.Visitor;
import application.model.*;
import application.repository.BookingRepository;
import application.repository.DoctorRepository;
import application.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Service
public class AppointmentService implements Visitable{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private ProvincialTax provincialTax;

    private Booking booking = null;

    private boolean isRoomsFull = false;
    private boolean isDoctorAvailable = true;


    /*
     * If cart has not been initialized, create it and populate with persisted appointments.
     */
    public void initCart(Patient patient) {
        patient.setCart(new Cart());
        Collection<Appointment> collected = this.appointmentRepository.findByUnbookedApps(patient.getUserId());
        patient.getCart().setAppointments(new ArrayList<>(collected));
        patient.setHasCart(true);
    }

    /*
     * Appointment is added to cart without being persisted
     */
    public boolean addAppointmentToCart(Patient patient, AppointmentForm appointmentForm) {

        Collection<Appointment> available = this.appointmentRepository.isAvailable(patient.getUserId(),
                stringToDate(appointmentForm.getDate()), stringToTime(appointmentForm.getTime()));

        if(available.size() == 0) {
            Appointment appointment = new Appointment(patient, stringToDate(appointmentForm.getDate()),
                    stringToTime(appointmentForm.getTime()), appointmentForm.getAppointment_type(),
                    appointmentForm.getLocation(), appointmentForm.getDescription());

            appointment.setUuid(UUID.randomUUID().toString());

            patient.getCart().addAppointment(appointment);

            return true;
        }

        else{
            return false;
        }

    }

    public boolean checkAnnualValid(Patient patient, AppointmentForm appointmentForm){

        Collection<Appointment> annual_taken = this.appointmentRepository.isAnnualAvailable(patient.getUserId(),
                stringToDate(appointmentForm.getDate()), "annual");

        if(annual_taken.size() != 0){
            return false;
        }

        return true;
    }

    /*
     * Retrieve appointments in cart to be displayed to client
     */
    public ArrayList<Appointment> getAppointmentsFromCart(Patient patient){

        return patient.getCart().getAppointments();
    }

    /*
     * Appointment updated from cart. Does not need to save once more to persist changes.
     */
    public ArrayList<Appointment> updateAppointment(Patient patient, Appointment appointment, String date, String time,
                                  String description, String appointment_type){

        appointment.setDate(stringToDate(date));
        appointment.setStartTime(stringToTime(time));
        appointment.setEndTime(stringToTime(time), appointment_type);
        appointment.setDescription(description);
        appointment.setAppointmentType(appointment_type);

        patient.getCart().updateAppointment(appointment);

        if(appointment.getAppointmentId() != 0){

            this.appointmentRepository.saveAndFlush(appointment);
        }

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

        if(appointment.getAppointmentId() != 0){

            this.appointmentRepository.delete(appointment.getAppointmentId());
        }
    }

    /*
     * Checking if appointment is already pesisted in database. If not, it is saved and retrieved with its Id.
     * Booking object instantiated with the patient, doctor, room and appoitment and then created in database.
     * Booked appointment now removed from cart after checkout.
     * TODO refactor checkoutAppointment() to save booking ONLY after payment is made.
     */
    public Booking checkoutAppointment(Patient patient, Appointment appointment) {

        Boolean exists = this.appointmentRepository.exists(appointment.getAppointmentId());

        if (!exists) {
            appointment = this.appointmentRepository.saveAndFlush(appointment);
        }
        
        Doctor doctor = getAvailableDoctor(appointment);
        //feature 4
        int room = getAvailableRoom(appointment);

        if(doctor == null){
            System.out.println("doctor is not available");
            isDoctorAvailable = false;
            return null;
        }
        if(room == 0) {
        	System.out.println("room is not available");// might need to change, simply print out for now.
            isRoomsFull = true;
            return null;
        }
        else {
            this.booking = new Booking(doctor, patient, appointment, room);
            this.booking.setTax(accept(provincialTax));
            this.booking.setTotal_fee(this.booking.getFee() + this.booking.getTax());
        }

        return this.booking;
    }

    public void confirmBooking(Booking booking, Patient patient) {
        this.bookingRepository.save(booking);
        patient.getCart().removeAppointment(booking.getAppointment());
        clinicService.updateClinicBookings(booking.getAppointment().getLocation());
    }

    public void quickRoomCheck(Appointment appointment){
        Collection<Integer> rooms = this.bookingRepository.findTakenRooms(appointment.getDate(), appointment.getStartTime(),
                appointment.getEndTime(), appointment.getLocation());
        if (rooms.size() == 5) {
            isRoomsFull = true;
        }
        isRoomsFull = false;
    }

    public void quickDoctorCheck(Appointment appointment){
        Collection<Integer> doctors = this.doctorRepository.findAvailableDoctor
                (appointment.getDate(), appointment.getStartTime(), appointment.getEndTime(), appointment.getLocation());
        if (doctors.isEmpty()) {
            isDoctorAvailable = false;
        }
        isDoctorAvailable = true;
    }

    /*
     * TODO feature 4: system must find an available doctor for the specified date-time
     */
    public Doctor getAvailableDoctor(Appointment appointment) {

    	Doctor doctor = new Doctor(); // query db to find available doctor
        Collection<Integer> doctorsId = this.
        		doctorRepository.
        		findAvailableDoctor
        		(appointment.getDate(), appointment.getStartTime(), appointment.getEndTime(), appointment.getLocation());
        
        if(!doctorsId.isEmpty()) 
        	doctor =this.doctorRepository.findByUserId( doctorsId.iterator().next() );
        else // no available doctor at that location
        	return null;
        
        return doctor;
    }

    /*
     * TODO feature 4: system must find an available room for the specified date-time
     */
    public int getAvailableRoom(Appointment appointment) {

    	Collection<Integer> takenRooms = this.bookingRepository.findTakenRooms(appointment.getDate(),
                appointment.getStartTime(), appointment.getEndTime(), appointment.getLocation());
    	int room = 0;
    	for(int i=1; i<=5; i++) {
    		if(!takenRooms.contains(i)) {
    				room = i;
    				break;
    			}
    	}
    	
    	return room; // return 0 for no room available at the specified location
    }


    //complete getbooking method
    public Collection<Booking> getBookings(User user){

        Collection<Booking> bookings = null;

        if(user.getUserType().equals("patient")) {
            bookings = this.bookingRepository.findByPatient((Patient) user);
        }


        if(user.getUserType().equals("doctor")) {
           bookings = this.bookingRepository.findByDoctor((Doctor) user);
        }


        if(user.getUserType().equals("nurse")) {
            bookings = this.bookingRepository.findAll();
        }


        if(bookings == null){

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
     * TODO modify function to truncate seconds
     */
    public static java.sql.Time stringToTime(String string_time) {

        LocalTime time = LocalTime.parse(string_time);

        return java.sql.Time.valueOf(time);
    }

    /*
     * Handle string conversion to date
     * TODO displays weekdays for non-persisted appointments. Need fix to stay consistent.
     */
    public static Date stringToDate(String string_date) {

        LocalDate date = null;

        date = LocalDate.parse(string_date);

        return java.sql.Date.valueOf(date);
    }

    public boolean isRoomsFull() {
        return isRoomsFull;
    }

    public boolean isDoctorAvailable() {
        return isDoctorAvailable;
    }

    @Override
    public Double accept(Visitor visitor) {
        return visitor.visit(this.booking);
    }
}