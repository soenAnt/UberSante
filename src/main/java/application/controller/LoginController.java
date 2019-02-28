package application.controller;

import application.Service.LoginAuthentication;
import application.model.Doctor;
import application.model.Patient;
import application.repository.DoctorRepository;
import application.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class LoginController {

    @Autowired
    private DoctorRepository doctorRepository;
    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public String loginPage(){
        System.out.println("------------------------------------ BEFORE");
        Doctor doctor = doctorRepository.findByPhysicianPermitNumber(5986621);

        System.out.println("------------------------------------ HEY: " + doctor);

        return "login";
    }

    @PostMapping(value = "/validate")
    public String loginPagelog(@ModelAttribute LoginForm loginForm){
        LoginAuthentication loginAuthentication = new LoginAuthentication(loginForm.getIdentification(), loginForm.getPassword());

        System.out.println("********************************"+loginForm.getIdentification()+"   "+loginForm.getPassword()+"\n"+
                loginAuthentication.getUserType()+" REAL:"+loginAuthentication.getRealAuthenticaton());
        return "home";
    }


}
