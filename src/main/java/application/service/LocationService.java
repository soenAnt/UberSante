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
     */
	public void relocateDoctor(String location, Doctor doctor) {
		doctor.setLocation(location);
		doctorRepository.save(doctor);
		clinicService.updateAllDoctors();
		notifyRelocation(doctor);
	}
	
	public void relocateNurse(String location, Nurse nurse) {
        nurse.setLocation(location);
        nurseRepository.save(nurse);
        clinicService.updateAllNurses();
        notifyRelocation(nurse);
	}

	public void notifyRelocation(User user){
	    String message = "You have been relocated to the " + user.getLocation() + " clinic.";
        Notification notification = new Notification(user, message, java.sql.Timestamp.valueOf(LocalDateTime.now()));
        this.notificationService.saveNotification(notification);
        notifyObserver(user);
    }

    public void relocateSomeDoctors(int num_doctor_relocation, String location) {

        Collection<Doctor> doctors = this.doctorRepository.findAll();
        for(Doctor doctor : doctors){
            if(num_doctor_relocation > 0 && !doctor.getLocation().equals(location)){
                relocateDoctor(location, doctor);
                num_doctor_relocation--;
            }
        }
	}

    public void relocateSomeNurses(int num_nurse_relocation, String location) {
        Collection<Nurse> nurses = this.nurseRepository.findAll();
        for(Nurse nurse : nurses){
            if(num_nurse_relocation > 0 && !nurse.getLocation().equals(location)){
                relocateNurse(location, nurse);
                num_nurse_relocation--;
            }
        }
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
