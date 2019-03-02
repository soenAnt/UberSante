package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DoctorScheduleController {
    @GetMapping(path="/schedule/{someID}")
    public String schedulePage(@PathVariable String someID) {
        System.out.println("*******************************"+someID);
        return "errorLogin";
    }
}
