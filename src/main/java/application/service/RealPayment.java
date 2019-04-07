package application.service;

import application.interfaces.IPayment;
import application.interfaces.Visitable;
import application.interfaces.Visitor;
import application.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealPayment implements IPayment {

    public RealPayment(){}

    @Override
    public Payment processPayment(String number, String month, String year, String cvc) {

        Payment payment = null;

        if(number.length() == 16 && month.length() == 2 && year.length() == 2 && cvc.length() == 3){
            payment = new Payment(number, month, year, cvc, true);
        }

        return payment;
    }

}
