package application.repository;

import application.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer>{

    Clinic findByName(String name);

	@Query(value = "SELECT count(doctors.doctor_id) "
			+ "FROM doctors LEFT JOIN users ON doctors.user_id=users.user_id WHERE users.location= ?1", nativeQuery = true)
    int get_num_doctors(String location);

	@Query(value = "SELECT count(doctors.doctor_id) "
            + "FROM doctors LEFT JOIN users ON doctors.user_id=users.user_id WHERE users.location= ?1", nativeQuery = true)
	int get_num_nurses(String location);

    @Query(value = "SELECT count(bookings.booking_id) "
            + "FROM bookings LEFT JOIN appointments ON bookings.appointment_id = appointments.appointment_id WHERE appointments.location= ?1", nativeQuery = true)
    int get_num_bookings(String location);
}
