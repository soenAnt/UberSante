package application.Service;

import application.controller.DoctorScheduleForm;
import application.model.Doctor;
import application.model.Schedule;
import application.repository.DoctorRepository;
import application.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DoctorScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    private int weekday;
    private int startTimeHour;
    private int startTimeMin;
    private int endTimeHour;
    private int endTimeMin;
    private boolean valid;
    private Doctor doctor;
    private Collection<Schedule> schedules;

    public void transferScheduleUpdate(DoctorScheduleForm doctorScheduleForm){
        String toInt;
        toInt = doctorScheduleForm.getWeekday();
        weekday = Integer.parseInt(toInt);
        toInt = doctorScheduleForm.getStartTimeHour();
        startTimeHour = Integer.parseInt(toInt);
        toInt = doctorScheduleForm.getStartTimeMin();
        startTimeMin = Integer.parseInt(toInt);
        toInt = doctorScheduleForm.getEndTimeHour();
        endTimeHour = Integer.parseInt(toInt);
        toInt = doctorScheduleForm.getEndTimeMin();
        endTimeMin = Integer.parseInt(toInt);
        System.out.print("************************* HERREEEE");
    }

    public void validateSchedule(){
        if((startTimeMin == endTimeMin)&&(endTimeHour == startTimeHour)){
            valid = false;
        }
        if(endTimeHour < startTimeHour){
            valid = false;
        }
    }
    public void findDoctorAndSchedule(int id){
        doctor = doctorRepository.findByUserId(id);
        schedules = scheduleRepository.findByDoctor(doctor);
    }
    public Doctor getDoctor(){return doctor;}

    public Collection<Schedule> getSchedules() {
        return schedules;
    }
    public boolean getValid(){return valid;}
}
