package service;

import dao.blueprint.IKweetDAO;
import dao.jpa.util.JPA;
import model.Kweet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class KweetService {
    @Inject
    @JPA
    private IKweetDAO kweetDAO;

    public void addKweet(Kweet kweet) {
        kweetDAO.addKweet(kweet);
    }

    public void removeKweet(Kweet kweet) {
        kweetDAO.removeKweet(kweet);
    }

    public Kweet findByID(String id) {
        return kweetDAO.findByID(id);
    }

    public List<Kweet> findByTag(String tag) {
        return kweetDAO.findByTag(tag);
    }

    public List<Kweet> getKweets() {
        return kweetDAO.getKweets();
    }
}
