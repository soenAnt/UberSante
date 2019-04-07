package application.repository;

import application.model.Appointment;
import application.model.Booking;
import application.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	Appointment findByAppointmentId(int id);

    Collection<Appointment> findByPatient(Patient patient);

    @Query(value = "SELECT * FROM appointments LEFT JOIN bookings ON " +
            "appointments.appointment_id = bookings.appointment_id WHERE appointments.patient_id =?1 AND " +
            "bookings.appointment_id IS NULL", nativeQuery = true)
    Collection<Appointment> findByUnbookedApps(int patient_id);

    @Query(value = "SELECT * FROM appointments WHERE patient_id=?1 AND date=?2 AND start_time=?3", nativeQuery = true)
    Collection<Appointment> isAvailable(int patient_id, Date date, Time start_time);

    @Query(value = "SELECT * FROM appointments WHERE patient_id=?1 AND YEAR(date)=YEAR(?2) AND appointments.appointment_type=?3", nativeQuery = true)
    Collection<Appointment> isAnnualAvailable(int userId, Date date, String annual);
}
