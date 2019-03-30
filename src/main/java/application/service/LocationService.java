package application.service;

import application.model.Doctor;
import application.model.Nurse;
import application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocationService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private NurseRepository nurseRepository;

	@Autowired
    private ClinicService clinicService;

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
	}
	
	public void relocateNurse(String location, String id) {
	    Nurse nurse;
	    Collection<Nurse> nurses = nurseRepository.findByAccessId(id);

	    if(nurses.size() == 1){
		    nurse = nurses.iterator().next();
		    nurse.setLocation(location);
		    nurseRepository.save(nurse);
		    clinicService.updateClinicNurses(location);
        }
	}
	
}
