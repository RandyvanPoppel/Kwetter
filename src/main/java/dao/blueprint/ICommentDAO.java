package dao.blueprint;

import model.Comment;

import java.util.List;

public interface ICommentDAO {
    void addComment(Comment comment);
    void removeComment(Comment comment);
    Comment findByID(String id);
    List<Comment> findByCreator(String creatorID);
    List<Comment> findByKweet(String kweetID);
    List<Comment> findByTag(String tag);
    List<Comment> getComments();
}
