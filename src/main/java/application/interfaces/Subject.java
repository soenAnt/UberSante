package application.interfaces;
import application.model.Notification;
import application.model.User;

public interface Subject {

    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver(User user);
}
