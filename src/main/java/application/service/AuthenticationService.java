package application.service;

import application.datastructure.RegisterForm;
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

@Service
public class AuthenticationService {

    private String authentication;
    private String password;
    private int userType;
    private String realAuthenticaton;
    private User userLogged;


    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private CatalogService catalogService;

    public Boolean processRegistration(RegisterForm registerForm){

        Collection<Patient> existingPatient =  this.patientRepository.findByEmail(registerForm.getEmail());

        if(existingPatient.isEmpty()){
            //successful registration
            // TODO allocate instantiation of patients to another class (i.e. factory?)
            Patient patient = new Patient(registerForm);
            this.userRepository.saveAndFlush(patient);
            this.catalogService.updateCatalog(patient);
            return true;
        }else{
            //unsuccessful registration
            // TODO verify email in real-time and let user know if it's already taken.
            return false;
        }
    }

    public void processLogin(String authentication, String password) {
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

    public boolean validateUser(){
        Collection<Doctor> doctor_collected = null;
        Collection<Nurse> nurse_collected = null;
        Collection<Patient> patient_collected  = null;

        // user type 1 is a doctor, type 2 a nurse and type 3 a patient
        switch (userType) {
            case 1:
                doctor_collected = doctorRepository.findByPhysicianPermitNumber(Integer.parseInt(realAuthenticaton));
                if(!doctor_collected.isEmpty()) {
                    Doctor doctor = doctor_collected.iterator().next();
                    if (doctor.getPassword().equals(this.password)) {
                        userLogged = doctor;
                        return true;
                    } else {
                        System.out.println("Password does not match.");
                    }
                }
                else System.out.println("Physician number does not exist.");
                break;
            case 2:
                nurse_collected = nurseRepository.findByAccessId(realAuthenticaton);
                if(!nurse_collected.isEmpty()) {
                    Nurse nurse = nurse_collected.iterator().next();
                    if (nurse.getPassword().equals(this.password)) {
                        userLogged = nurse;
                        return true;
                    } else {
                        System.out.println("Password does not match.");
                    }
                }
                else System.out.println("Access id does not exist.");
                break;
            case 3:
                patient_collected = patientRepository.findByEmail(realAuthenticaton);
                if(!patient_collected.isEmpty()) {
                    Patient patient = patient_collected.iterator().next();
                    if (patient.getPassword().equals(this.password)) {
                        userLogged = patient;
                        return true;
                    } else {
                        System.out.println("Password does not match.");
                    }
                }
                else System.out.println("Email does not exist.");
                break;
        }
        return false;
    }

    public User getUserLogged(){return userLogged;}

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
