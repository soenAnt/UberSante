package application.service;

import application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

	@Autowired
	ClinicRepository clinicRepository;
	
	public void updateClinic(String location) {
		clinicRepository.update_num_doctors(location);
		clinicRepository.update_num_nurses(location);
		clinicRepository.update_num_bookings(location);
		clinicRepository.update_num_rooms(location);
	}
	
	
}
