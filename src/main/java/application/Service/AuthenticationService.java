package application.Service;

import application.model.Doctor;
import application.model.Nurse;
import application.model.Patient;
import application.model.User;
import application.repository.DoctorRepository;
import application.repository.NurseRepository;
import application.repository.PatientRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

//@Service
public class AuthenticationService {
    private String authentication;
    private String password;
    private int userType;
    private String realAuthenticaton;
    private User userLogged;

/*
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;
*/

    //public AuthenticationService(){}

    public AuthenticationService(String authentication, String password) {
        this.authentication = authentication;
        this.password = password;
        userType();
        convertRealUserAuthentication();
    }

    // If user type 3 is patient, 2 is nurse and 1 is a doctor
    private void userType(){
        if(authentication.charAt(0)== ',') {

            if (authentication.charAt(1) == ',') {
                userType = 1;
            }
            else {
                userType = 2;
            }
        }
        else{
            userType = 3;
        }
    }

    private void convertRealUserAuthentication(){
        switch (userType){
            case 1: realAuthenticaton = authentication.substring(2);
                break;
            case 2: realAuthenticaton = authentication.substring(1,authentication.length()-1);
                break;
            case 3: realAuthenticaton = authentication.substring(0,authentication.length()-2);
                break;
        }
    }

/*    public boolean validateUser(){
        Doctor doctor = null;
        Nurse nurse = null;
        Collection<Patient> patient  = null;

        User user = userRepository.findByPassword(password);
        if (user != null) {

            // user type 1 is a doctor, type 2 a nurse and type 3 a patient
            switch (userType) {
                case 1:
                    doctor = doctorRepository.findByPhysicianPermitNumber(Integer.parseInt(realAuthenticaton));
                    userLogged = doctor;
                    break;
                case 2:
                    nurse = nurseRepository.findByAccessId(realAuthenticaton);
                    userLogged = nurse;
                    break;
                case 3:
                    patient = patientRepository.findByEmail(realAuthenticaton);
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
    }*/

    //public User getUserLogged(){return userLogged;}

    public int getUserType() {
        return userType;
    }
    public String getRealAuthenticaton() {
        return realAuthenticaton;
    }
    public String getPassword() {
        return password;
    }
}
