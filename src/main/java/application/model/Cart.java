package application.model;

import java.util.ArrayList;

public class Cart {

	private ArrayList<Appointment> appointments;

	public Cart() {
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment appointment){
	    appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }
}
