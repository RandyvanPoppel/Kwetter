package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "kweet.findByID", query = "SELECT k FROM Kweet k WHERE k.id = :id"),
        @NamedQuery(name = "kweet.findByTag", query = "SELECT k FROM Kweet k WHERE k.message LIKE :tag"),
        @NamedQuery(name = "kweet.getAllKweets", query = "SELECT k FROM Kweet k")
})
@Entity(name = "Kweet")
public class Kweet implements Serializable {

    @Id
    private String id;

    @ManyToOne
    private Kweeter creator;

    @ManyToMany
    private List<Kweeter> likes;

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
