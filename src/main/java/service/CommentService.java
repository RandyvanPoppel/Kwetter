package service;

import dao.blueprint.ICommentDAO;
import dao.jpa.util.JPA;
import model.Comment;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class CommentService {
    @Inject
    @JPA
    private ICommentDAO commentDAO;

    public void addComment(Comment comment) {
        commentDAO.addComment(comment);
    }

    public void removeComment(Comment comment) {
        commentDAO.removeComment(comment);
    }

    public Comment findByID(String id) {
        return commentDAO.findByID(id);
    }

    public List<Comment> findByCreator(String creatorID) {
        return commentDAO.findByCreator(creatorID);
    }

    public List<Comment> findByKweet(String kweetID) {
        return commentDAO.findByKweet(kweetID);
    }

    public List<Comment> getComments(String kweetID) {
        return commentDAO.getComments();
    }
}
