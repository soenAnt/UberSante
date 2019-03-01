package application.repository;

import application.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
    Doctor findByPhysicianPermitNumber(int physicianPermitNumber);
}
