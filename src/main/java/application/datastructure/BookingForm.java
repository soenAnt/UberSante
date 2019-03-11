package application.datastructure;

/*
 * The attribute names and their getters/setters must match the form input field name
 * As typed in the field names in the HTML files
 */

public class BookingForm {

    private String booking_type;
    private String doctor;
    private String room;
    private String date;
    private String time;
    private String description;

    public BookingForm(){}

    public BookingForm(String booking_type, String doctor, String room, String date, String time, String description){

        this.booking_type = booking_type;
        this.doctor = doctor;
        this.room  = room;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getBooking_type(){
        return booking_type;
    }

    public void setBooking_type(String booking_type){
        this.booking_type = booking_type;
    }


    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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
