package application.repository;

import application.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

    Collection<Patient> findByEmail(String email);
    
    public Patient findByUserId(int id);
}
