package model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "Admin")
public class Admin extends User implements Serializable {

    protected Admin() {}

    public Admin(String username, String password) {
        super(username, password);
        this.setUserRole(UserRole.ADMIN);
    }
}
