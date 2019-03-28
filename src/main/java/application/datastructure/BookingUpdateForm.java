package application.datastructure;

public class BookingUpdateForm {

    private String appointment_type;
    private String date;
    private String time;
    private String doctor;
    private String room;

    public BookingUpdateForm(){}

    public BookingUpdateForm(String appointment_type, String date, String time, String doctor, String room) {
        this.appointment_type = appointment_type;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
