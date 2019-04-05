package service;

import dao.blueprint.IUserDAO;
import dao.jpa.util.JPA;
import model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {
    @Inject
    @JPA
    private IUserDAO userDAO;

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void removeUser(User user) {
        userDAO.removeUser(user);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public User authenticate(String username, String password) {
        return userDAO.authenticate(username, password);
    }
}
