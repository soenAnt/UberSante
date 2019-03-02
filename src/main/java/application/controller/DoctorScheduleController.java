package application.controller;

import application.model.Doctor;
import application.model.Schedule;
import application.repository.DoctorRepository;
import application.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;


@Controller
public class DoctorScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping(path="/schedule/{someID}")
    public String schedulePage(@PathVariable int someID) {
        System.out.println("*******************************"+someID);
        Doctor doctor = doctorRepository.findByUserId(someID);
        System.out.println("*******************************HEYYYY"+doctor);
        Collection<Schedule> schedulesCol = scheduleRepository.findByDoctor(doctor);
        System.out.println("*****************************DAMNNNNNNN"+schedulesCol);
        return "errorLogin";
    }
}
