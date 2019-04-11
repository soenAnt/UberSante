package application.service;

import application.model.Clinic;
import application.model.Doctor;
import application.model.Nurse;
import application.repository.ClinicRepository;
import application.repository.DoctorRepository;
import application.repository.NurseRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.model.User;

import java.util.Collection;

@Service
public class AdminService {

    @Autowired
    private ClinicRepository clinics;

    @Autowired
    private NurseRepository nurses;

    @Autowired
    private DoctorRepository doctors;

    @Autowired
    private UserRepository users;

    public Collection<Clinic> getClinics(){
        return this.clinics.findAll();
    }

    public Collection<Nurse> getNurses(){
        return this.nurses.findAll();
    }

    public Collection<Doctor> getDoctors(){
        return this.doctors.findAll();
    }

    public User getUser(int id) {
        return this.users.findByUserId(id);
    }
}
