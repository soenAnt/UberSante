package application.controller;

import application.service.ScheduleService;
import application.datastructure.ScheduleForm;
import application.model.Doctor;
import application.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;


@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    private Doctor doctor;
    private Collection<Schedule> schedules;

    @GetMapping(path="/schedule/{someID}")
    public String schedulePage(@PathVariable int someID, Model model) {
        scheduleService.findDoctorAndSchedule(someID);
        doctor = scheduleService.getDoctor();
        schedules = scheduleService.getSchedules();
        model.addAttribute("user", doctor);
        model.addAttribute("schedules", schedules);
        return "schedule";
    }

    @PostMapping(value = "/schedule/validate")
    public String scheduleChange(@ModelAttribute ScheduleForm scheduleForm, Model model){
        scheduleService.transferScheduleUpdate(scheduleForm);
        model.addAttribute("user", doctor);
        model.addAttribute("schedules", schedules);

        /// TODO Inside Validate method, make sure the update doesnt override a booking
        if(scheduleService.validateSchedule()){
            model.addAttribute("success","success");
            scheduleService.save();
            return "schedule";
        }
        else {
            model.addAttribute("error","error");
            return "schedule";
        }
    }

    @GetMapping(path="/schedule/home")
    public String scheduleToHome( Model model){
        model.addAttribute("user", doctor);

        return "home";
    }

}
