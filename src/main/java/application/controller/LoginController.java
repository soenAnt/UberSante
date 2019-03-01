package application.controller;

import application.Service.LoginAuthentication;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class LoginController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @PostMapping(value = "/validate")
    public String loginPagelog(@ModelAttribute LoginForm loginForm){
        LoginAuthentication loginAuthentication = new LoginAuthentication(loginForm.getIdentification(), loginForm.getPassword());

       boolean validate = validateUser(loginAuthentication.getRealAuthenticaton(), loginAuthentication.getPassword(),loginAuthentication.getUserType());
       if(validate){
           //Start the session
           return "home";
       }
       else{
           // generate the error page for the authentication
           return "errorLogin";
       }
    }

    private boolean validateUser(String identification, String password, int userType){
        Doctor doctor = null;
        Nurse nurse = null;
        Collection<Patient> patient  = null;

        // user type 1 is a doctor, type 2 a nurse and type 3 a patient
        switch(userType){
            case 1: doctor = doctorRepository.findByPhysicianPermitNumber(Integer.parseInt(identification));
                break;
            case 2: nurse = nurseRepository.findByAccessId(identification);
                break;
            case 3: patient = patientRepository.findByEmail(identification);
                break;
        }

        User user = userRepository.findByPassword(password);
          if(doctor != null || nurse != null | patient != null) {
           // System.out.println("************************** MADE ITTTT");
            if (user != null) {
                return true;
            }
        }
        return false;
    }


}
