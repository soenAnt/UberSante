package application.web;
import application.model.Patient;
import application.model.User;
import application.repository.PatientRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationPage(){
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute RegisterForm registerForm){

        Collection<Patient> existingPatient =  this.patientRepository.findByEmail(registerForm.getEmail());

        if(existingPatient.isEmpty()){
            //successful registration
            // TODO allocate instantiation of patients to another class (i.e. factory?)
            Patient patient = new Patient(registerForm);
            this.userRepository.save((User) patient);
            return ("home");
        }else{
            //unsuccessful registration
            // TODO verify email in real-time and let user know if it's already taken.
            System.out.println("email already exists");
            return ("register");
        }
    }
}