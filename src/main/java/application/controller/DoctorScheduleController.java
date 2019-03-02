package application.controller;

import application.Service.DoctorScheduleService;
import application.model.Doctor;
import application.model.Schedule;
import application.repository.DoctorRepository;
import application.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Time;
import java.util.Collection;


@Controller
public class DoctorScheduleController {

    @Autowired
    private DoctorScheduleService doctorScheduleService;

    private Doctor doctor;
    private Collection<Schedule> schedules;

    @GetMapping(path="/schedule/{someID}")
    public String schedulePage(@PathVariable int someID, Model model) {
        doctorScheduleService.findDoctorAndSchedule(someID);
        doctor = doctorScheduleService.getDoctor();
        schedules = doctorScheduleService.getSchedules();
        model.addAttribute("user", doctor);
        model.addAttribute("schedules", schedules);
        return "schedule";
    }

    @PostMapping(value = "/schedule")
    public String scheduleChange(@ModelAttribute DoctorScheduleForm doctorScheduleForm, Model model){
        doctorScheduleService.transferScheduleUpdate(doctorScheduleForm);
        model.addAttribute("user", doctor);
        model.addAttribute("schedules", schedules);

        if(doctorScheduleService.validateSchedule()){
            model.addAttribute("success","success");
            return "schedule";
        }
        else {
            model.addAttribute("error","error");
            return "schedule";
        }
    }

}
