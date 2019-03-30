package application.service;

import application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	NurseRepository nurseRepository;
	
	public void relocateDoctor(String location, int id) {
		doctorRepository.relocateDoctor(location, id);
	}
	
	public void relocateNurse(String location, int id) {
		nurseRepository.relocateNurse(location, id);
	}
	
}
