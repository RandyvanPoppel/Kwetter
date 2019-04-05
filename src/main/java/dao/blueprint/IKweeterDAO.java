package dao.blueprint;

import model.Kweeter;

import java.util.List;

public interface IKweeterDAO {
    void addKweeter(Kweeter kweeter);
    void removeKweeter(Kweeter kweeter);
    List<Kweeter> getKweeters();
}
