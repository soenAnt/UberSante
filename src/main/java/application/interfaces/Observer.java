package application.interfaces;

import application.model.User;

public interface Observer {

    void update(User user, String string);
}
