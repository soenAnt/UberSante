package application.service;

import application.model.Clinic;
import application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

	@Autowired
	ClinicRepository clinicRepository;
	
	public void updateClinicNurses(String location) {

		int num_nurses = clinicRepository.get_num_nurses(location);
		Clinic clinic = clinicRepository.findByName(location);
		clinic.setNum_nurses(num_nurses);
        clinicRepository.save(clinic);
	}

    public void updateClinicDoctors(String location) {

        int num_doctors = clinicRepository.get_num_doctors(location);
        Clinic clinic = clinicRepository.findByName(location);
        clinic.setNum_doctors(num_doctors);
        clinicRepository.save(clinic);
    }

    public void updateClinicBookings(String location) {

        int num_bookings = clinicRepository.get_num_bookings(location);
        Clinic clinic = clinicRepository.findByName(location);
        clinic.setNum_bookings(num_bookings);
        clinicRepository.save(clinic);
    }

}
