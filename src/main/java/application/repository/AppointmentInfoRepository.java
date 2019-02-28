package application.repository;

import application.model.AppointmentInfo;
import application.model.Cart;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentInfoRepository extends JpaRepository<AppointmentInfo, Integer>{
	
	public AppointmentInfo findByAppointmentInfoId(int id);
	
	@Query("SELECT appointmentInfo FROM Appointment WHERE appointmentId=?")
    public AppointmentInfo findByAppointmentId(int id);
	
	//public Collection<AppointmentInfo> findByClientId(int id);
	
}
