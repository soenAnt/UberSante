package application.repository;

import application.model.AppointmentInfo;
import application.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
    
    public Cart findByCartId(int id);
    
    @Query("SELECT cartId FROM Cart WHERE appointmentInfo=?")
    public int findByAppointmentInfo(AppointmentInfo info);
}