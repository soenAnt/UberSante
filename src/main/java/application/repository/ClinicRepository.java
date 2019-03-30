package application.repository;

import application.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer>{
	
	@Query(value = "UPDATE clinics "
			+ "SET num_doctors = (SELECT count(doctor_id) "
			+ "FROM doctors WHERE users.location = ?1) "
			+ "WHERE name= ?1")
    public void update_num_doctors(String location);
	@Query(value = "UPDATE clinics "
			+ "SET num_nurses = (SELECT count(nurse_id) "
			+ "FROM nurses WHERE users.location = ?1) "
			+ "WHERE name= ?1")
	public void update_num_nurses(String location);
	@Query(value = "UPDATE clinics "
			+ "SET num_bookings = (SELECT count(appointment_id) "
			+ "FROM bookings WHERE bookings.location = ?1) "
			+ "WHERE name=?1")
	public void update_num_bookings(String location);
	@Query(value = "UPDATE clinics "
			+ "SET num_rooms = (SELECT count(room) "
			+ "FROM bookings WHERE bookings.location = ?1) "
			+ "WHERE name=?1")
	public void update_num_rooms(String location);
}
