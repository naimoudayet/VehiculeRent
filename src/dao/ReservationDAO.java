package dao;

import java.util.List;
import models.Reservation;

public interface ReservationDAO {

    // create
    void create(Reservation reservation);

    // update
    void update(Reservation reservation);

    // read all
    List<Reservation> readAll();

    // read
    Reservation read(String id);

    // delete
    void delete(String id);

}
