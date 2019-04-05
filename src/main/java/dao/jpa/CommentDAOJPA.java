package dao.jpa;

import dao.blueprint.ICommentDAO;
import dao.jpa.util.JPA;
import model.Comment;

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
public class CommentDAOJPA implements ICommentDAO {
    @PersistenceContext(unitName = "Kwetter")
    private EntityManager em;

    @Override
    public void addComment(Comment comment) {
        em.persist(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        em.remove(em.merge(comment));
    }

    @Override
    public Comment findByID(String id) {
        TypedQuery<Comment> query = em.createNamedQuery("comment.findByID", Comment.class);
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
    public List<Comment> findByCreator(String creatorID) {
        TypedQuery<Comment> query = em.createNamedQuery("comment.findByCreator", Comment.class);
        query.setParameter("creatorID", creatorID);
        try{
            return query.getResultList();
        }
        catch (NoResultException e) {
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }
    }

    @Override
    public List<Comment> findByKweet(String kweetID) {
        TypedQuery<Comment> query = em.createNamedQuery("comment.findByKweet", Comment.class);
        query.setParameter("kweetID", kweetID);
        try{
            return query.getResultList();
        }
        catch (NoResultException e) {
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }
    }

    @Override
    public List<Comment> findByTag(String tag) {
        TypedQuery<Comment> query = em.createNamedQuery("comment.findByTag", Comment.class);
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
    public List<Comment> getComments() {
        TypedQuery<Comment> query = em.createNamedQuery("comment.getAllComments", Comment.class);
        try{
            return query.getResultList();
        }
        catch (NoResultException e) {
            Logger.getLogger(getClass().getName()).log(Level.INFO, null, e);
            return null;
        }
    }
}
