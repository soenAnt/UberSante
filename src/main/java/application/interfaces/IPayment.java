package application.interfaces;

import application.model.Payment;

public interface IPayment {
    Payment processPayment(String number, String month, String year, String cvc);
}
