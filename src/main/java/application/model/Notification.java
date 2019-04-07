package application.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "message")
    private String message;

    @Column(name = "day_time")
    private Timestamp day_time;

    public Notification(){}

    public Notification(User user, String message, Timestamp datetime){
        this.user = user;
        this.message = message;
        this.day_time = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return day_time;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.day_time = timestamp;
    }
}
