package application.repository;

import application.model.Appointment;
import application.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

    Doctor findByUserId(int userId);

    Collection<Doctor> findByPhysicianPermitNumber(int physicianPermitNumber);
    
    @Query(value = "SELECT doctor_id FROM schedules, "
    		+ "("
	    		+ "SELECT doctor FROM doctors LEFT JOIN "
		    		+ "("
		    		+ "SELECT t0.booking_id, t0.doctor_id, t0.date, t0.start_time, t0.end_time "
		    		+ "FROM (SELECT bookings.booking_id, bookings.doctor_id, appointments.date, appointments.start_time, appointments.end_time "
		    		+ "FROM bookings INNER JOIN appointments ON appointments.appointment_id=bookings.appointment_id) AS t0 "
		    		+ "WHERE ((t0.start_time =?2 AND t0.end_time =?3 AND t0.date =?1)) IS TRUE"
		    		+ ") "
	    		+ "AS t ON (doctors.user_id = t.doctor_id) WHERE t.doctor_id IS NULL"
    		+ ") "
    		+ "AS x WHERE x.user_id = schedules.doctor_id "
    		+ "AND schedules.day_of_week = (SELECT {fn dayname(?1)}) "
    		+ "AND schedules.start_time <=?2 "
    		+ "AND schedules.end_time >=?3",
    		nativeQuery = true)
    Collection<Doctor> findAvailableDoctor(Date date, Time start_time, Time end_time);;

}
