package dao;

import java.util.List;
import models.Bus;

public interface BusDAO {

    // create
    void create(Bus bus);

    // update
    void update(Bus bus);

    // delete
    void delete(Bus bus);

    // read all
    List<Bus> readAll();

    // read
    Bus read(String id);

}
