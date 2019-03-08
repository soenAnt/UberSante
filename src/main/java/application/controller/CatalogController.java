package application.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import application.model.Doctor;
import application.model.Nurse;
import application.model.Patient;
import application.service.CatalogService;

@Controller
public class CatalogController {
	
	@Autowired
    private CatalogService catalogService;
	
	private Nurse nurse;
	
	private Collection<Doctor> doctors;
	private Collection<Patient> patients;

	@GetMapping(path="/appointment/nurse/{someID}")
    public String appointmentPage(@PathVariable String someID, Model model) {
        catalogService.findNurse(someID);
        nurse = catalogService.getNurse();
        doctors = catalogService.getDoctors();
        patients = catalogService.getPatients();
        model.addAttribute("user", nurse);
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);
        return "appointment";
    }

}
