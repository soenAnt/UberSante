package application.Service;

public class LoginAuthentication {
    private String authentication;
    private String password;
    private int userType;
    private boolean valid;
    private String realAuthenticaton;

    public LoginAuthentication(String authentication, String password) {
        this.authentication = authentication;
        this.password = password;
        userType();
    }

    // If user type 3 is patient, 2 is nurse and 1 is a doctor
    private void userType(){

        if(authentication.charAt(0)== ',') {

            if (authentication.charAt(1) == ',') {
                userType = 1;
            }
            else {
                userType = 2;
            }
        }
        else{
            userType = 3;
        }
    }

    public int getUserType() {
        return userType;
    }
}
