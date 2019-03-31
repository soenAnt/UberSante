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

	@Autowired
    LocationService locationService;
	
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

    /**
     * Feature 5 staff relocation trigger is set here
     * @param location
     */
    public void updateClinicBookings(String location) {

        int num_bookings = clinicRepository.get_num_bookings(location);
        int num_nurses = clinicRepository.get_num_nurses(location);
        int num_doctors = clinicRepository.get_num_doctors(location);

        int num_doctor_relocation = num_bookings - (num_doctors)*2;
        int num_nurse_relocation = num_bookings - (num_nurses)*3;

        // if a clinic has twice the number of bookings than staff members, we relocate other clinic staff to this location
        if(num_doctor_relocation > 0){
            locationService.relocateSomeDoctors(num_doctor_relocation*2, location);
        }
        if(num_nurse_relocation > 0){
            locationService.relocateSomeNurses(num_nurse_relocation*3, location);
        }

        Clinic clinic = clinicRepository.findByName(location);
        clinic.setNum_bookings(num_bookings);
        clinicRepository.save(clinic);
    }

    public void updateAll(){

	    updateClinicNurses("Westmount");
	    updateClinicDoctors("Westmount");
	    updateClinicBookings("Westmount");

        updateClinicNurses("Mont-Royal");
        updateClinicDoctors("Mont-Royal");
        updateClinicBookings("Mont-Royal");

        updateClinicNurses("Outremont");
        updateClinicDoctors("Outremont");
        updateClinicBookings("Outremont");
    }

}
