package dao;

import java.util.List;
import models.Voiture;

public interface VoitureDAO {

    // create
    void create(Voiture voiture);

    // update
    void update(Voiture voiture);

    // delete
    void delete(Voiture voiture);

    // read all
    List<Voiture> readAll();

    // read
    Voiture read(String id);

}
