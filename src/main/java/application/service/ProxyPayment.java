package application.service;

import application.interfaces.IPayment;
import application.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProxyPayment implements IPayment {
    @Autowired
    private RealPayment realPayment;

    public ProxyPayment() {}

    @Override
    public Payment processPayment(String number, String month, String year, String cvc) {
        if(realPayment == null){
            realPayment = new RealPayment();
        }
        return realPayment.processPayment(number, month, year, cvc);
    }
}
