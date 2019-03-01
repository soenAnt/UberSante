package application.controller;

import application.service.AuthenticationService;
import application.datastructure.LoginForm;
import application.model.Doctor;
import application.model.Nurse;
import application.model.Patient;
import application.model.User;
import application.repository.DoctorRepository;
import application.repository.NurseRepository;
import application.repository.PatientRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    private User userLogged = null;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @PostMapping(value = "/validate")
    public String loginPagelog(@ModelAttribute LoginForm loginForm, Model model){

        this.authenticationService.processLogin(loginForm.getIdentification(), loginForm.getPassword());

        boolean validate = authenticationService.validateUser();

        if(validate){
           //Start the session
           userLogged = authenticationService.getUserLogged();
           model.addAttribute("user", userLogged);
           return "home";
        }

        else{
           // generate the error page for the authentication
           return "errorLogin";
        }
    }

}
