package dao.blueprint;

import model.Kweet;

import java.util.List;

public interface IKweetDAO {
    void addKweet(Kweet kweet);
    void removeKweet(Kweet kweet);
    Kweet findByID(String id);
    List<Kweet> findByTag(String tag);
    List<Kweet> getKweets();
}
