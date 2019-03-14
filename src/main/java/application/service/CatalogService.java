package application.service;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Doctor;
import application.model.Nurse;
import application.model.Patient;
import application.model.User;
import application.model.UserCatalog;
import application.repository.UserRepository;
import application.repository.NurseRepository;

@Service
public class CatalogService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private NurseRepository nurseRepository;
	private Collection<Patient> patients;
	private Collection<Doctor> doctors;
	private Collection<User> users;
	
	private Nurse nurse;
	private UserCatalog userCatalog;
	
	public void init() {
		users = this.userRepository.findAll();

		for(User user : users){
		   this.userCatalog.getInstance().put(user.getUserId(), user);
		   }
	}
	
	public void findNurse(String id){
        nurse = (Nurse) nurseRepository.findByAccessId(id);
    }
	
	public Nurse getNurse() {
		return nurse;
	}
	
	public Collection<Patient> getPatients() {
		for(User u: users){
            if(u.getUserType().equals("patient")) {
                patients.add((Patient)u);
            }
        }
		return patients;
	}
	
	public Collection<Doctor> getDoctors() {
		for(User u: users){
            if(u.getUserType().equals("doctor")) {
                doctors.add((Doctor)u);
            }
        }
		return doctors;
	}
	
	// Doctors fixed at 7, so can only add patients
	public void updateCatalog(Patient patient){
		   // note that the whole point of saveAndFlush() was to retrieve that patientId
		   userCatalog.getInstance().put(patient.getUserId(), patient); 
		}

	
}
