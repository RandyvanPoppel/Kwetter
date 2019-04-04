package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity(name = "Comment")
public class Comment {

    @Id
    private String id;

    @ManyToOne
    private Kweeter creator;

    @ManyToOne
    private Kweet kweet;

    private String message;

    protected Comment() {}

    public Comment(Kweeter creator, Kweet kweet, String message) {
        id = UUID.randomUUID().toString();
        this.creator = creator;
        this.kweet = kweet;
        this.message = message;
    }

    public Kweeter getCreator() {
        return creator;
    }

    public Kweet getKweet() {
        return kweet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
