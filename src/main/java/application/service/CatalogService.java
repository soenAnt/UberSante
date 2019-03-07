package application.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Doctor;
import application.model.Nurse;
import application.model.Patient;
import application.model.User;
import application.repository.UserRepository;
import application.repository.DoctorRepository;
import application.repository.NurseRepository;
import application.repository.PatientRepository;

@Service
public class CatalogService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	private Collection<User> users;
	private Collection<Patient> patients;
	private Collection<Doctor> doctors;
	
	private Nurse nurse;
	private Patient patient;
	private Doctor doctor;
	
	public void findNurse(String id){
        nurse = (Nurse) nurseRepository.findByAccessId(id);
    }
	
	public Nurse getNurse() {
		return nurse;
	}
	
	public void findUsers() {
		users = this.userRepository.findAll();
	}
	
	public Collection<Patient> getPatients() {
		for(User x: users){
            if(x.getUserType().equals("patient")) {
                patient = patientRepository.findByUserId(x.getUserId());
                patients.add(patient);
            }
        }
		return patients;
	}
	
	public Collection<Doctor> getDoctors() {
		for(User x: users){
            if(x.getUserType().equals("doctor")) {
                doctor = doctorRepository.findByUserId(x.getUserId());
                doctors.add(doctor);
            }
        }
		return doctors;
	}

	
}
