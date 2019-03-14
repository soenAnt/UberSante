package application.service;


import application.datastructure.AppointmentForm;
import application.model.*;
import application.repository.AppointmentRepository;
import application.repository.BookingRepository;
import application.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

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


    //cancel booking to be used only by Nurse
    public void cancelBooking(int booking){

        Booking bookingo = this.bookingRepository.findByBookingId(booking);
        this.bookingRepository.delete(bookingo);

    }
    
    // create follow-up appointment by doctor
    public void followUp(Doctor doctor, Patient patient, AppointmentForm appointmentForm){

        Appointment followUpAppointment = new Appointment(patient, AppointmentService.stringToDate(appointmentForm.getDate()),
                            AppointmentService.stringToTime(appointmentForm.getTime()), appointmentForm.getAppointment_type(),
                            appointmentForm.getDescription());
        
        int room = this.appointmentService.getAvailableRoom(followUpAppointment);

        Appointment appointment = this.appointmentRepository.saveAndFlush(followUpAppointment);

        Booking followUpBooking = new Booking(doctor, patient, appointment, room);
        
        this.bookingRepository.save(followUpBooking);
    }
    
    // return a patient
    public Patient getPatient(int patientId) {

        Patient patient = this.patientRepository.findByUserId(patientId);
        return patient;
    }
}
