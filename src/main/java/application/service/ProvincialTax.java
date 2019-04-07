package application.service;

import application.interfaces.Visitor;
import application.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class ProvincialTax implements Visitor{

    @Override
    public Double visit(Booking quebec_booking) {

        double GST = 0.05;
        double QST = 0.09975;
        double currentFee = quebec_booking.getFee();

        return currentFee*GST + currentFee*QST;
    }
}
