package application.web;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String registrationPage(){
        return "register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView register(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String gender,
            @RequestParam String dateOfBirth,
            @RequestParam String healthCard,
            @RequestParam String phoneNumber,
            @RequestParam String address,
            @RequestParam String password,
            @RequestParam String confirmPassword, HttpServletRequest request){
        /*
         * Boolean value must be replaced by call to registerPatient()
         * registerPatient() should return a boolean depending on successful database patient creation
         * Upon success, user is redirected to login page; else, an error message is shown and user stays
         * on the register page until successful registration
         */
        Boolean success = false;
        if(success){
            //successful registration
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.MOVED_PERMANENTLY);
            return new ModelAndView("redirect:/login");
        }else{
            //unsuccessful registration
            request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.BAD_REQUEST);
            return new ModelAndView("redirect:/register");
        }
    }
}