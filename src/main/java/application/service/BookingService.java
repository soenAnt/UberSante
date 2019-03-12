package application.service;


import application.model.*;
import application.repository.BookingRepository;
import application.repository.AppointmentRepository;
import application.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

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


    //cancelbooking to be used only by Nurse
    public void cancelBooking(Booking booking){

        this.bookingRepository.delete(booking);

    }
    
    // create follow-up appointment by doctor
    public Booking followUp(Doctor doctor, Patient patient, AppointmentForm appointmentForm){
        Appointment followUpAppointment = new Appointment(patient, AppointmentService.stringToDate(appointmentForm.getDate()),
                            AppointmentService.stringToTime(appointmentForm.getTime()), appointmentForm.getAppointment_type(),
                            appointmentForm.getDescription());
        
        int room = this.appointmentService.getAvailableRoom(followUpAppointment);
        Booking followUpBooking = new Booking(doctor, patient, appointment, room);
        
        this.bookingService.save(followUpBooking);
        
        return followUpBooking;
    }
    
    // return a patient
    public Patient getPatient(int patientId) {
        return this.patientRepository.findByUserId(patientId);
    }
}
