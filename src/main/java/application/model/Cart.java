package application.model;

import application.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

public class Cart {

    @Autowired
    AppointmentRepository appointment_repo;

	private ArrayList<Appointment> appointments;

	public Cart(Patient patient) {
	    initCart(patient);
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    private void initCart(Patient patient) {
        Collection<Appointment> collected = this.appointment_repo.findByPatient(patient);
        appointments = new ArrayList<>(collected);
    }

    public void addAppointment(Appointment appointment){
	    appointments.add(appointment);
    }


    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }
}
