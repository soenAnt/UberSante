package application.service;

import application.interfaces.IPayment;


public class ProxyPayment implements IPayment {
    private RealPayment realPayment;

    public ProxyPayment() {}

    @Override
    public boolean processPayment(String number, String month, String year, String cvc) {
        if(realPayment == null){
            realPayment = new RealPayment();
        }
        return realPayment.processPayment(number, month, year, cvc);
    }
}
