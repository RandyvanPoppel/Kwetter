package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "Kweet")
public class Kweet implements Serializable {

    @Id
    private String id;

    private Kweeter creator;

    private String message;

    protected Kweet() {}

    public Kweet(Kweeter creator, String message) {
        id = UUID.randomUUID().toString();
        this.creator = creator;
        this.message = message;
    }

    public Kweeter getCreator() {
        return creator;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
