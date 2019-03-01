package application.interfaces;

public interface IPayment {
    boolean processPayment(String number, String month, String year, String cvc);
}
