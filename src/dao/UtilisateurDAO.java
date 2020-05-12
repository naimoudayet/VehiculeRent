package dao;

import models.Utilisateur;

public interface UtilisateurDAO {

    // create
    String create(Utilisateur utilisateur);

    // update
    void update(Utilisateur utilisateur);

    // delete
    void delete(String id);
}
