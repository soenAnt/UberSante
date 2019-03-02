package application.datastructure;

/*
 * The attribute names and their getters/setters must match the form input field name
 * As typed in the field names in the HTML files
 */

public class AppointmentForm {

    private String appointment_type;
    private String date;
    private String time;
    private String description;

    public AppointmentForm(){}

    public AppointmentForm(String appointment_type, String date, String time, String description) {
        this.appointment_type = appointment_type;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getAppointment_type() {
        return appointment_type;
    }

    public void setAppointment_type(String appointment_type) {
        this.appointment_type = appointment_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
