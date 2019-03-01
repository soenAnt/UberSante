package application.controller;

import application.Service.AuthenticationService;
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
    private DoctorRepository doctorRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;

    private User userLogged = null;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @PostMapping(value = "/validate")
    public String loginPagelog(@ModelAttribute LoginForm loginForm, Model model){
        AuthenticationService authenticationService = new AuthenticationService(loginForm.getIdentification(), loginForm.getPassword());

       boolean validate = validateUser(authenticationService.getRealAuthenticaton(), authenticationService.getPassword(), authenticationService.getUserType());
      //boolean validate = authenticationService.validateUser();

       if(validate){
           //Start the session
           //userLogged = authenticationService.getUserLogged();
           model.addAttribute("user", userLogged);
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

        User user = userRepository.findByPassword(password);
        if (user != null) {

            // user type 1 is a doctor, type 2 a nurse and type 3 a patient
            switch (userType) {
                case 1:
                    doctor = doctorRepository.findByPhysicianPermitNumber(Integer.parseInt(identification));
                    userLogged = doctor;
                    break;
                case 2:
                    nurse = nurseRepository.findByAccessId(identification);
                    userLogged = nurse;
                    break;
                case 3:
                    patient = patientRepository.findByEmail(identification);
                    userLogged = patient.iterator().next();
                    break;
            }

            if(doctor != null || nurse != null | patient != null) {
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }


}
