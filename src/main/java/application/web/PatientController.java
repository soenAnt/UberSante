package application.web;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import application.model.Appointment;
import application.model.AppointmentInfo;
import application.model.Cart;
import application.model.Patient;
import application.repository.AppointmentInfoRepository;
import application.repository.AppointmentRepository;
import application.repository.CartRepository;
import application.repository.PatientRepository;

@Controller
public class PatientController {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	AppointmentInfoRepository appointmentInfoRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	PatientRepository patientRepository;

    @GetMapping("/appointment")
    public String appointmentPage(){
        return "appointment";
    }

    @PostMapping("/appointment")
    public String processAppointment(@RequestParam String appointment_type,
                                     @RequestParam String date,
                                     @RequestParam String time,
                                     @RequestParam String description,
                                     Model model){

        //Appointment appointment = new Appointment(appointment_type, date, time, description);
        //model.addAttribute("cart", cart); <-- should add the cart fragment to homepage
    	
    	// testing //
    	Patient p = patientRepository.findByUserId(1);
    	Date d = Date.valueOf(date);
    	System.out.println("time: " + time);
    	Timestamp ts = Timestamp.valueOf(date + " " + time + ":00");
    	this.save(appointment_type, d, ts, p);
    	//AppointmentInfo info = appointmentInfoRepository.findByAppointmentInfoId(5);
    	//clear(info.getAppointmentInfoId());
    	checkout(6, 1); // checkout appointment 6 on user 1
    	// end testing //
        return "home";
    }
    
    @RequestMapping(value="/removeFromCart", method= RequestMethod.GET)
    public String clear(@RequestParam(value="appointmentInfoId", required = true) int infoId){
        // remove appointment from cart
    	AppointmentInfo info = appointmentInfoRepository.findByAppointmentInfoId(infoId);
    	int cart = cartRepository.findByAppointmentInfo(info);
    	if(info != null) {
    		cartRepository.delete(cart);
    		appointmentInfoRepository.delete(infoId);
    	}
        return "/";
    }

    @RequestMapping(value="/persistAppointment", method= RequestMethod.GET)
    public String save(String appointmentType, Date date, Timestamp startTime, Patient patient){
        // persist the appointment in table appointment_info
    	int id = -1;
    	if(appointmentType.equals("walk-in")) {
    		id = 1;
    	} else if(appointmentType.equals("annual")) {
    		id = 2;
    	}
    	AppointmentInfo info = appointmentInfoRepository.findByAppointmentInfoId(id);
    	AppointmentInfo newAppointment = null;
    	if(info != null) {
			newAppointment = new AppointmentInfo(info); // prototype; using clone didn't work properly
			newAppointment.setDate(date);
			newAppointment.setStartTime(startTime);
    	} else {
    		newAppointment = new AppointmentInfo(date, startTime, appointmentType);
    	}
    	
    	appointmentInfoRepository.save(newAppointment);
    	cartRepository.save(new Cart(patient, newAppointment));
        return "/";
    }

    @RequestMapping(value="/checkout", method= RequestMethod.GET)
    public String checkout(@RequestParam(value="appointmentInfoId", required = true) int infoId,
    		@RequestParam(value="patientId", required = true) int ptId){
 		// redirect to checkout page -> payment page (Matthew)
    	
		// persist the appointment in table appointments
    	AppointmentInfo info = appointmentInfoRepository.findByAppointmentInfoId(infoId);
    	Patient patient = patientRepository.findByUserId(ptId);
    	int cartId = cartRepository.findByAppointmentInfo(info);
    	
    	// get doctor
    	// get room
    	
    	// uncomment this and remove appointment = null
    	//Appointment appointment = new Appointment(room, info, doctor, patient);
    	Appointment appointment = null;
    	
    	appointmentRepository.save(appointment);
    	cartRepository.delete(cartId);
    	
        return "checkout";
    }
    
    @RequestMapping(value="/cancelAppointment", method= RequestMethod.GET)
    public String cancel(@RequestParam(value="appointmentId", required = true) int id) {
    	// remove the appointment from table appointments
    	Appointment rdv = appointmentRepository.findByAppointmentId(id);
    	AppointmentInfo info = appointmentInfoRepository.findByAppointmentId(id);
    	
    	if(rdv != null) {
    		appointmentRepository.delete(id);
    		appointmentInfoRepository.delete(info.getAppointmentInfoId());
    	}
    	
    	return "/";
    }

}
