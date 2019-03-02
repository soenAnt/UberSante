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

    private String weekday;
    private int startTimeHour;
    private int startTimeMin;
    private int endTimeHour;
    private int endTimeMin;
    private boolean valid;
    private Doctor doctor;
    private Collection<Schedule> schedules;
    private Schedule schedule;

    public void transferScheduleUpdate(DoctorScheduleForm doctorScheduleForm){
        String toInt;
        weekday = doctorScheduleForm.getWeekday();
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

    public boolean validateSchedule(){
        valid = true;
        if((startTimeMin == endTimeMin)&&(endTimeHour == startTimeHour)){
            valid = false;
        }
        if(endTimeHour < startTimeHour){
            valid = false;
        }
        return valid;
    }

    public void findDoctorAndSchedule(int id){
        doctor = doctorRepository.findByUserId(id);
        schedules = scheduleRepository.findByDoctor(doctor);
    }
    private void findSchedule(){
        for(Schedule x: schedules){
            if(x.getDayOfWeek().equals(weekday))
                schedule = x;
        }
    }
    public Doctor getDoctor(){return doctor;}
    public Collection<Schedule> getSchedules() {
        return schedules;
    }
}
