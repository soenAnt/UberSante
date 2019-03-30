package application.service;

import application.interfaces.Observer;
import application.interfaces.Subject;
import application.model.Doctor;
import application.model.Notification;
import application.model.Nurse;
import application.model.User;
import application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class LocationService implements Subject{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private NurseRepository nurseRepository;

	@Autowired
    private ClinicService clinicService;

	@Autowired
    private NotificationService notificationService;

    /**
     * When num_bookings gets too lopsided in one location, we sent staff to help out.
     * @param location
     * @param id
     */
	public void relocateDoctor(String location, int id) {
		Doctor doctor = doctorRepository.findByUserId(id);
		doctor.setLocation(location);
		doctorRepository.save(doctor);
		clinicService.updateClinicDoctors(location);
		notifyRelocation(doctor);
	}
	
	public void relocateNurse(String location, String id) {
	    Nurse nurse;
	    Collection<Nurse> nurses = nurseRepository.findByAccessId(id);

	    if(nurses.size() == 1){
		    nurse = nurses.iterator().next();
		    nurse.setLocation(location);
		    nurseRepository.save(nurse);
		    clinicService.updateClinicNurses(location);
		    notifyRelocation(nurse);
        }
	}

	public void notifyRelocation(User user){
	    String message = "You have been relocated to the " + user.getLocation() + " clinic.";
        Notification notification = new Notification(user, message, java.sql.Timestamp.valueOf(LocalDateTime.now()));
        this.notificationService.saveNotification(notification);
        notifyObserver(user);
    }

    @Override
    public void register(Observer o) {

    }

    @Override
    public void unregister(Observer o) {

    }

    @Override
    public void notifyObserver(User user) {
	    user.setNotification(1);
        notificationService.setNotificationStatus(user);
    }
}
