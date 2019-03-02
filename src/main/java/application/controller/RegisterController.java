package application.controller;
import application.datastructure.RegisterForm;
import application.model.Cart;
import application.model.Patient;
import application.model.User;
import application.repository.PatientRepository;
import application.repository.UserRepository;
import application.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@Controller
public class RegisterController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationPage(){
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute RegisterForm registerForm){

        Boolean success = this.authenticationService.processRegistration(registerForm);

        if(success){
            return ("login");
        }else{
            System.out.println("email already exists");
            return ("register");
        }
    }
}