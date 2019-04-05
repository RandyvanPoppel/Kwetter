package dao.jpa;

import dao.blueprint.IUserDAO;
import dao.jpa.util.JPA;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@JPA
public class UserDAOJPA implements IUserDAO {
    @PersistenceContext(unitName = "Kwetter")
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void removeUser(User user) {
        em.remove(em.merge(user));
    }

    @Override
    public User getUserByUsername(String username) {
        TypedQuery<User> query = em.createNamedQuery("user.findByUsername", User.class);
        query.setParameter("username", username);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }

    }

    @Override
    public User authenticate(String username, String password) {
        TypedQuery<User> query = em.createNamedQuery("user.authenticateUser", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try{
            return query.getSingleResult();

        }catch (NoResultException e){
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }

    }
}
