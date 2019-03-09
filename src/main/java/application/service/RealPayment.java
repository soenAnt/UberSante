package application.service;

import application.interfaces.IPayment;
import application.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class RealPayment implements IPayment {

    public RealPayment(){}

    @Override
    public Payment processPayment(String number, String month, String year, String cvc) {
        Payment successfulPayment = new Payment();

        if(number.length() == 16 && month.length() == 2 && year.length() == 2 && cvc.length() == 3){
            successfulPayment = new Payment(number, month, year, cvc, true);
        }

        return successfulPayment;
    }
}
