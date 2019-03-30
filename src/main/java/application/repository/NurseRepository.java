package application.repository;

import application.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Integer>{
   Collection<Nurse> findByAccessId(String accessId);
   
   @Query(value = "UPDATE nurses SET location = ?1 WHERE user_id = ?2")
   public void relocateNurse(String location, int user_id);
}
