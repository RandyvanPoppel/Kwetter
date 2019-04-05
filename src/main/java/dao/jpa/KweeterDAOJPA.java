package dao.jpa;

import dao.blueprint.IKweeterDAO;
import dao.jpa.util.JPA;
import model.Kweeter;

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
public class KweeterDAOJPA implements IKweeterDAO {
    @PersistenceContext(unitName = "Kwetter")
    private EntityManager em;

    @Override
    public void addKweeter(Kweeter kweeter) {
        em.persist(kweeter);
    }

    @Override
    public void removeKweeter(Kweeter kweeter) {
        em.remove(em.merge(kweeter));
    }

    @Override
    public List<Kweeter> getKweeters() {
        TypedQuery<Kweeter> query = em.createNamedQuery("kweeter.getAllKweeters", Kweeter.class);
        try{
            return query.getResultList();
        }
        catch (NoResultException e) {
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }
    }
}
