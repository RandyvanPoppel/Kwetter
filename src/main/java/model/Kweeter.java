package model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Kweeter")
public class Kweeter extends User implements Serializable {

    @OneToMany(mappedBy = "Kweeter")
    private List<Kweet> kweets;

    @ManyToMany(mappedBy = "Kweeter")
    private List<Kweet> likedKweets;

    @OneToMany(mappedBy = "Kweeter")
    private List<Comment> comments;

    protected Kweeter() {}

    public Kweeter(String username, String password) {
        super(username, password);
        this.setUserRole(UserRole.KWEETER);
    }
}
