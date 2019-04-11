package application.controller;


import application.model.Doctor;
import application.model.Nurse;
import application.service.AdminService;
import application.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.*;
import application.model.User;

@Controller
@SessionAttributes(value = {"user", "appointments", "patient", "doctor", "notification", "notifications",
        "doctors", "nurses", "clinics", "relocateUser"})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/showclinics")
    public String clinics(Model model) {

        model.addAttribute("clinics", this.adminService.getClinics());
        return "clinics";
    }

    @GetMapping("/showstaff")
    public String staff(Model model){

        model.addAttribute("nurses", this.adminService.getNurses());
        model.addAttribute("doctors", this.adminService.getDoctors());
        return "staff";
    }

    @RequestMapping("/relocate")
    public String relocate(@RequestParam(value="id") int id, Model model) {

        User user = this.adminService.getUser(id);
        model.addAttribute("relocateUser", user);
        model.addAttribute("clinics", this.adminService.getClinics());
        return "relocateForm";
    }

    @PostMapping("/relocateComplete")
    public String relocate(@RequestParam String location, Model model) {

        User user = (User)((BindingAwareModelMap) model).get("relocateUser");

        if(user.getUserType().equals("doctor")){
            this.locationService.relocateDoctor(location, (Doctor) user);
        }
        else{
            this.locationService.relocateNurse(location, (Nurse) user);
        }

        model.addAttribute("nurses", this.adminService.getNurses());
        model.addAttribute("doctors", this.adminService.getDoctors());

        return "staff";
    }
}
