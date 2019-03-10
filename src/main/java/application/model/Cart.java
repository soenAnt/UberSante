package application.model;

import java.util.ArrayList;

public class Cart {

	private ArrayList<Appointment> appointments;
	private ArrayList<Booking> bookings;

	public Cart() {
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public ArrayList<Booking> getBookings(){
	    return bookings;
    }


    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void setBookings(ArrayList<Booking> bookings) {this.bookings = bookings;}

    public void addAppointment(Appointment appointment){
	    appointments.add(appointment);
    }

    public void addBooking(Booking booking){
	    bookings.add(booking);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void removeBooking(Booking booking){
	    bookings.remove(booking);
    }

    public void updateAppointment(Appointment appointment) {
        int index = appointments.indexOf(appointment);
        appointments.set(index, appointment);
    }

    public void updateBooking(Booking booking){
	    int index = bookings.indexOf(booking);
	    bookings.set(index, booking);
    }
}
