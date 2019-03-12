package application.repository;

import application.model.Appointment;

import application.model.Booking;
import application.model.Doctor;
import application.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

    Collection<Booking> findByPatient(Patient patient);

    Collection<Booking> findByDoctor(Doctor doctor);
    
    @Query(value = "SELECT room FROM bookings INNER JOIN appointments "
    		+ "WHERE bookings.appointment_id = appointments.appointment_id "
    		+ "AND date=?1 "
    		+ "AND start_time <= ?2 "
    		+ "AND end_time >= ?3", nativeQuery = true)
    Collection<Integer> findTakenRooms(Date date, Time start_time, Time end_time);
}
