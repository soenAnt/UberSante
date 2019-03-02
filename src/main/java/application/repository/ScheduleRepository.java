package application.repository;

import application.model.Doctor;
import application.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
    Collection<Schedule> findByDoctor(Doctor doctor);
}
