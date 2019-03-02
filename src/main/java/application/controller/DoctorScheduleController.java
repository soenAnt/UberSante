package application.controller;

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

import java.util.Collection;


@Controller
public class DoctorScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    private Doctor doctor;
    private Collection<Schedule> schedules;

    @GetMapping(path="/schedule/{someID}")
    public String schedulePage(@PathVariable int someID, Model model) {
        doctor = doctorRepository.findByUserId(someID);
        schedules = scheduleRepository.findByDoctor(doctor);
        model.addAttribute("user", doctor);
        model.addAttribute("schedules", schedules);
        return "schedule";
    }

    @PostMapping(value = "/schedule")
    public String scheduleChange(@ModelAttribute ScheduleForm scheduleForm){
        System.out.print("*************************"+scheduleForm.getWeekday()+" "+scheduleForm.getStartTimeHour()+" "+scheduleForm.getStartTimeMin()
                +" "+scheduleForm.getEndTimeHour()+" "+scheduleForm.getEndTimeMin());
        System.out.print("*************************"+doctor.getLastName());

        return "home";
    }

}
