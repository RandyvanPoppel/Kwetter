package model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "USERROLE")
@Entity(name = "User")
public abstract class User implements Serializable {

    @Id
    private String id;

    @Column(unique = true)
    private String username;

    @JsonbTransient
    private String password;

    private UserRole userRole;

    protected User() {}

    public User(String username, String password) {
        id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
