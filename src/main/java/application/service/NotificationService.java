package application.service;

import application.model.Notification;
import application.model.User;
import application.repository.NotificationRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

@Service
public class NotificationService implements Observer{

    @Autowired
    private UserRepository users;

    @Autowired
    private NotificationRepository notificationRepository;

    private boolean notificationStatus;

    public Boolean getNotificationStatus(User userLogged) {
        return notificationStatus;
    }

    public Boolean getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(User user) {
        this.users.save(user);
    }

    public Collection<Notification> getNotifications(User userLogged) {
        return this.notificationRepository.findByUser(userLogged);
    }

    public void saveNotification(Notification notification) {
        this.notificationRepository.save(notification);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
