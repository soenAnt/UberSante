package application.controller;

import application.model.Notification;
import application.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import application.model.User;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Collection;

@Controller
@SessionAttributes(value = {"user", "appointments", "notification", "notifications"})
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public String notification(Model model){
        User user = (User) ((BindingAwareModelMap) model).get("user");
        Collection<Notification> notifications = this.notificationService.getNotifications(user);
        user.setNotification(0);
        this.notificationService.setNotificationStatus(user);
        model.addAttribute("notification", user.getNotification());
        return "notifications";
    }
}
