package dao;

import models.Vehicule;

public interface VehiculeDAO {

    // create
    void create(Vehicule vehicule);

    // update
    void update(Vehicule vehicule);

    // delete
    void delete(String matricule);
}
