package application.service;


import application.datastructure.AppointmentForm;
import application.datastructure.BookingUpdateForm;
import application.model.*;
import application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static application.service.AppointmentService.stringToDate;
import static application.service.AppointmentService.stringToTime;

@Service
public class BookingService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    //return bookings of a user by userid
    public Collection<Booking> getBookings(User user){

        return this.appointmentService.getBookings(user);

    }


    //updateBooking to be used only by Nurse
    public ArrayList<Booking> updateBooking(Patient patient, Doctor doctor, Booking booking, Appointment appointment, int room){

        booking.setDoctor(doctor);
        booking.setRoom(room);
        booking.setAppointment(appointment);

        patient.getCart().updateAppointment(appointment);

        this.appointmentRepository.save(appointment);

        return patient.getCart().getBookings();
    }


    //cancel booking to be used only by Nurse
    public void cancelBooking(int booking){

        Booking bookingo = this.bookingRepository.findByBookingId(booking);
        this.bookingRepository.delete(bookingo);

    }
    
    // create follow-up appointment by doctor
    public void followUp(Doctor doctor, Patient patient, AppointmentForm appointmentForm){

        Appointment followUpAppointment = new Appointment(patient, stringToDate(appointmentForm.getDate()),
                            stringToTime(appointmentForm.getTime()), appointmentForm.getAppointment_type(),
                            appointmentForm.getDescription());
        
        int room = this.appointmentService.getAvailableRoom(followUpAppointment);

        Appointment appointment = this.appointmentRepository.saveAndFlush(followUpAppointment);

        Booking followUpBooking = new Booking(doctor, patient, appointment, room);
        
        this.bookingRepository.save(followUpBooking);
    }

    public boolean updateValidate_Save(BookingUpdateForm bookingUpdateForm, Booking updatebooking){
        System.out.println("HELLLLLOOOOOOOOOOOOOOOOOOOOOOOOOO");
        boolean doctorValidator = false;
        boolean roomValidator = false;
        //transfering all the new appointment information
        Appointment patientAppointment = updatebooking.getAppointment();
        patientAppointment.setDate(truncateTimeFromDate(stringToDate(bookingUpdateForm.getDate())));
        patientAppointment.setAppointmentType(bookingUpdateForm.getAppointment_type());
        patientAppointment.setStartTime(stringToTime(bookingUpdateForm.getTime()));
        patientAppointment.setEndTime(stringToTime(bookingUpdateForm.getTime()),bookingUpdateForm.getAppointment_type());

        // creating doctor object to validate
        Doctor doctor = doctorRepository.findByUserId(Integer.parseInt(bookingUpdateForm.getDoctor()));
        doctorValidator = isDoctorValid(doctor,patientAppointment);
        System.out.println("Verify doctor "+doctorValidator);

        // validate room
        int room = Integer.parseInt(bookingUpdateForm.getRoom());
        roomValidator = isRoomValid(room,patientAppointment);
        System.out.println("Verify room "+roomValidator);

        //save booking
        if(doctorValidator && roomValidator){

            return true;
        }
        else {
            return false;
        }
    }
    // return a patient
    public Patient getPatient(int patientId) {
        Patient patient = this.patientRepository.findByUserId(patientId);
        return patient;
    }
    //returns a booking
    public Booking getbooking(int bookingId){
        Booking booking = bookingRepository.findByBookingId(bookingId);
        return booking;
    }


    //return doctor List
    public Collection<User> getDoctorList(){
        return userRepository.findByUserType("doctor");
    }

    //validating a doctor based on a appointment
    private boolean isDoctorValid(Doctor doctor, Appointment appointment){
       Collection<Integer> doctorsId = this.
                doctorRepository.
                findAvailableDoctor
                        (appointment.getDate(), appointment.getStartTime(), appointment.getEndTime());
        System.out.println("validator");
      boolean valid = false;
        for(int id:doctorsId){
            System.out.println(id);
            if(id == doctor.getUserId()){}
            valid = true;
        }
        return valid;
    }

    private boolean isRoomValid(int room, Appointment appointment){
        boolean valid = false;
        Collection<Integer> takenRooms = this.bookingRepository.findTakenRooms(appointment.getDate(), appointment.getStartTime(), appointment.getEndTime());

        System.out.println("Printing ROOOM taken");
        for(int id : takenRooms){
            System.out.println(id);
        }
        if(!takenRooms.contains(room)) {
              valid = true;
        }
        return valid;
    }
    private Date truncateTimeFromDate(Date date) {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date date_no_time = null;

        try {

            date_no_time = formatter.parse(formatter.format(date));

        } catch (ParseException e) {

            e.printStackTrace();
        }

        return date_no_time;
    }
}
