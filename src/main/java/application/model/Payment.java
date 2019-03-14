package application.model;

public class Payment {
    private String number;
    private String month;
    private String year;
    private String cvc;
    private boolean isValid;

    public Payment() {
        this.isValid = false;
    }

    public Payment(String number, String month, String year, String cvc, boolean isValid) {
        this.number = number;
        this.month = month;
        this.year = year;
        this.cvc = cvc;
        this.isValid = isValid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
