package dao.blueprint;

import model.User;

public interface IUserDAO {
    void addUser(User user);
    void removeUser(User user);
    User getUserByUsername(String username);
    User authenticate(String username, String password);
}
