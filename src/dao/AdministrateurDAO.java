package dao;

import models.Administrateur;

public interface AdministrateurDAO {

    // login
    boolean login(Administrateur administrateur);
    
    // create
    void create(Administrateur administrateur);
    
}
