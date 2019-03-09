package application.model;

import groovy.lang.Singleton;
import java.util.HashMap;

@Singleton
public class BookingCatalog {

    private static HashMap<Integer, User> bookingCatalog = null;

    private BookingCatalog() {
        // TODO Auto-generated constructor stub
    }

    public static HashMap<Integer, User> getInstance() {
        if (bookingCatalog == null) {
            bookingCatalog = new HashMap<Integer, User>();
        }
        return bookingCatalog;
    }

}
