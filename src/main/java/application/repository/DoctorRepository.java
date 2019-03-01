package application.repository;

import application.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
    Collection<Doctor> findByPhysicianPermitNumber(int physicianPermitNumber);
}
