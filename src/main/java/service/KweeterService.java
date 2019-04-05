package service;

import dao.blueprint.IKweeterDAO;
import dao.jpa.util.JPA;
import model.Kweeter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class KweeterService {
    @Inject
    @JPA
    private IKweeterDAO kweeterDAO;

    public void addKweeter(Kweeter kweeter) {
        kweeterDAO.addKweeter(kweeter);
    }

    public void removeKweeter(Kweeter kweeter) {
        kweeterDAO.removeKweeter(kweeter);
    }

    public List<Kweeter> getKweeters() {
        return kweeterDAO.getKweeters();
    }
}
