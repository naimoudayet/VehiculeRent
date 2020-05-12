package dao;

import java.util.List;
import models.Client;

public interface ClientDAO {

    // create
    void create(Client client);

    // update
    void update(Client client);

    // delete
    void delete(Client client);

    // read all
    List<Client> readAll();

    // read
    Client read(String id);
     
}
