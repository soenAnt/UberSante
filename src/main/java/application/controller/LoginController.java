package application.controller;

import application.model.Notification;
import application.model.Patient;
import application.service.AppointmentService;
import application.service.AuthenticationService;
import application.datastructure.LoginForm;
import application.model.User;
import application.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Collection;


@Controller
@SessionAttributes(value = {"user", "appointments", "notification", "notifications"})
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private NotificationService notificationService;

    private User userLogged = null;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus status, Model model){

        status.setComplete();
        model.addAttribute("appointments", null);
        model.addAttribute("user", null);
        return "redirect:/";
    }

    @PostMapping(value = "/validate")
    public String loginPagelog(@ModelAttribute LoginForm loginForm, Model model, SessionStatus status){

        this.authenticationService.processLogin(loginForm.getIdentification(), loginForm.getPassword());

        boolean validate = authenticationService.validateUser();

        if(validate){
           //Start the session
           userLogged = authenticationService.getUserLogged();

           if(userLogged.getUserType().equals("patient")){
               Patient patient = (Patient) userLogged;
               this.appointmentService.initCart(patient);
               model.addAttribute("appointments", patient.getCart().getAppointments());
           }

           Collection<Notification> notifications = this.notificationService.getNotifications(userLogged);
           model.addAttribute("notifications", notifications);

           model.addAttribute("notification", userLogged.getNotification());
           model.addAttribute("user", userLogged);
           return "home";
        }

        else{
           // generate the error page for the authentication
           return "errorLogin";
        }
    }

}
