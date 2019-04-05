package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "kweeter.getAllKweeters", query = "SELECT k FROM Kweeter k")
})
@Entity(name = "Kweeter")
public class Kweeter extends User implements Serializable {

    @OneToMany(mappedBy = "creator")
    private List<Kweet> kweets;

    @ManyToMany(mappedBy = "likes")
    private List<Kweet> likedKweets;

    @OneToMany(mappedBy = "creator")
    private List<Comment> comments;

    protected Kweeter() {}

    public Kweeter(String username, String password) {
        super(username, password);
        this.setUserRole(UserRole.KWEETER);
    }
}
