package model;

import javax.persistence.*;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "comment.findByID", query = "SELECT c FROM Comment c WHERE c.id = :id"),
        @NamedQuery(name = "comment.findByCreator", query = "SELECT c FROM Comment c WHERE c.creator = :creatorID"),
        @NamedQuery(name = "comment.findByKweet", query = "SELECT c FROM Comment c WHERE c.kweet = :kweetID"),
        @NamedQuery(name = "comment.findByTag", query = "SELECT c FROM Comment c WHERE c.message LIKE :tag"),
        @NamedQuery(name = "comment.getAllComments", query = "SELECT c FROM Comment c")
})
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
