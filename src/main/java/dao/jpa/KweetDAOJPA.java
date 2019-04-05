package dao.jpa;

import dao.blueprint.IKweetDAO;
import dao.jpa.util.JPA;
import model.Kweet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@JPA
public class KweetDAOJPA implements IKweetDAO {
    @PersistenceContext(unitName = "Kwetter")
    private EntityManager em;

    @Override
    public void addKweet(Kweet kweet) {
        em.persist(kweet);
    }

    @Override
    public void removeKweet(Kweet kweet) {
        em.remove(em.merge(kweet));
    }

    @Override
    public Kweet findByID(String id) {
        TypedQuery<Kweet> query = em.createNamedQuery("kweet.findByID", Kweet.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }
    }

    @Override
    public List<Kweet> findByTag(String tag) {
        TypedQuery<Kweet> query = em.createNamedQuery("kweet.findByTag", Kweet.class);
        query.setParameter("tag", tag);
        try{
            return query.getResultList();
        }
        catch (NoResultException e) {
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }
    }

    @Override
    public List<Kweet> getKweets() {
        TypedQuery<Kweet> query = em.createNamedQuery("kweet.getAllKweets", Kweet.class);
        try{
            return query.getResultList();
        }
        catch (NoResultException e) {
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }
    }
}
