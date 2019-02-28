package application.Service;

import application.model.Doctor;
import application.model.Nurse;
import application.repository.DoctorRepository;
import application.repository.NurseRepository;
import application.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginAuthentication {
    private String authentication;
    private String password;
    private int userType;
    private boolean valid;
    private String realAuthenticaton;

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public LoginAuthentication(String authentication, String password) {
        this.authentication = authentication;
        this.password = password;
        userType();
        convertRealUserAuthentication();
        //isUserValid();
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
    private void isUserValid(){
        System.out.println("------------------------------------ BEFORE");
        //Doctor doctor = doctorRepository.findByPhysicianPermitNumber(Integer.parseInt(realAuthenticaton));

       // System.out.println("------------------------------------ HEY: " + doctor.getCity());

    }
    public int getUserType() {
        return userType;
    }
    public String getRealAuthenticaton() {
        return realAuthenticaton;
    }
}
