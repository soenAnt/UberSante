package application.repository;

import application.model.Notification;
import application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

    Collection<Notification> findByUser(User userLogged);
}
