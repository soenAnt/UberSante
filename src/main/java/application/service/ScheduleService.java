package application.service;

import application.datastructure.ScheduleForm;
import application.model.Doctor;
import application.model.Schedule;
import application.repository.DoctorRepository;
import application.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Collection;

@Service
public class ScheduleService {

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

    public void transferScheduleUpdate(ScheduleForm scheduleForm){
        String toInt;
        weekday = scheduleForm.getWeekday();
        toInt = scheduleForm.getStartTimeHour();
        startTimeHour = Integer.parseInt(toInt);
        toInt = scheduleForm.getStartTimeMin();
        startTimeMin = Integer.parseInt(toInt);
        toInt = scheduleForm.getEndTimeHour();
        endTimeHour = Integer.parseInt(toInt);
        toInt = scheduleForm.getEndTimeMin();
        endTimeMin = Integer.parseInt(toInt);
    }

    /// TODO Validate if the schedule is overriding a patient booking or appointment
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
    public void save(){
        findSchedule();
        Time startTime = new Time(startTimeHour,startTimeMin,0);
        Time endTime = new Time(endTimeHour,endTimeMin,0);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        scheduleRepository.save(schedule);
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
