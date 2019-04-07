package application.interfaces;

import application.model.Booking;

public interface Visitor {

    Double visit(Booking quebec_booking);

    /** When other provinces join UberSante
     *
     * Double visit(QuebecBooking qc_booking);
     * Double visit(AlbertaBooking alb_booking);
     * Double visit(OntarioBooking ont_booking)
     * etc ...
     */
}
