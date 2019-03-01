package application.service;

import application.interfaces.IPayment;

public class RealPayment implements IPayment {

    public RealPayment(){}

    @Override
    public boolean processPayment(String number, String month, String year, String cvc) {
        boolean successfulPayment = false;

        if(number.length() == 12 && cvc.length() == 3){
            successfulPayment = true;
        }

        return successfulPayment;
    }
}
