package model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "Moderator")
public class Moderator extends User implements Serializable {

    protected Moderator() {}

    public Moderator(String username, String password)
    {
        super(username, password);
        this.setUserRole(UserRole.MODERATOR);
    }
}
