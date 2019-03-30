package application.service;

import application.datastructure.AppointmentForm;
import application.model.*;
import application.repository.BookingRepository;
import application.repository.DoctorRepository;
import application.repository.NurseRepository;
import application.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Service
public class LocationService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	NurseRepository nurseRepository;
	
	public void relocateDoctor(String location, int doctorId) {
		doctorRepository.relocateDoctor(location, doctorId);
	}
	
	public void relocateNurse(String location, int nurseId) {
		nurseRepository.relocateNurse(location, nurseId);
	}
}