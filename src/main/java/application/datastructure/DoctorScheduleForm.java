package application.datastructure;

public class DoctorScheduleForm {
    private String weekday;
    private String startTimeHour;
    private String startTimeMin;
    private String endTimeHour;
    private String endTimeMin;

    public DoctorScheduleForm(String weekday, String startTimeHour, String startTimeMin, String endTimeHour, String endTimeMin) {
        this.weekday = weekday;
        this.startTimeHour = startTimeHour;
        this.startTimeMin = startTimeMin;
        this.endTimeHour = endTimeHour;
        this.endTimeMin = endTimeMin;
    }
    public DoctorScheduleForm(){}

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getStartTimeHour() {
        return startTimeHour;
    }

    public void setStartTimeHour(String startTimeHour) {
        this.startTimeHour = startTimeHour;
    }

    public String getStartTimeMin() {
        return startTimeMin;
    }

    public void setStartTimeMin(String startTimeMin) {
        this.startTimeMin = startTimeMin;
    }

    public String getEndTimeHour() {
        return endTimeHour;
    }

    public void setEndTimeHour(String endTimeHour) {
        this.endTimeHour = endTimeHour;
    }

    public String getEndTimeMin() {
        return endTimeMin;
    }

    public void setEndTimeMin(String endTimeMin) {
        this.endTimeMin = endTimeMin;
    }
}
