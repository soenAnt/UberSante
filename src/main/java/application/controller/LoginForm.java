package application.controller;

public class LoginForm {
    private String identification;
    private String password;

    public LoginForm(){}
    public LoginForm(String identification, String password) {
        this.identification = identification;
        this.password = password;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}