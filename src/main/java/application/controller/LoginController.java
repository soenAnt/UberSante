package application.controller;

import application.service.AuthenticationService;
import application.datastructure.LoginForm;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes(value = "user")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    private User userLogged = null;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @PostMapping(value = "/validate")
    public String loginPagelog(@ModelAttribute LoginForm loginForm, Model model){

        this.authenticationService.processLogin(loginForm.getIdentification(), loginForm.getPassword());

        boolean validate = authenticationService.validateUser();

        if(validate){
           //Start the session
           userLogged = authenticationService.getUserLogged();
           model.addAttribute("user", userLogged);
           return "home";
        }

        else{
           // generate the error page for the authentication
           return "errorLogin";
        }
    }

}
