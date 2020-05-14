package api;

import config.Database;
import dao.ReservationDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Client;
import models.Reservation;
import models.Utilisateur;
import models.Vehicule;

public class ReservationAPI implements ReservationDAO {

    private Database db;
    private Connection connection;
    private Statement statement;

    private ResultSet resultSet;
    private String sql;

    public ReservationAPI() {
        try {

            db = new Database();
            connection = db.openConnection();
            statement = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Reservation reservation) {

        String id = UUID.randomUUID().toString();

        try {

            sql = "INSERT INTO reservation(id, id_client, matricule, date_debut, date_fin, prix_total)"
                    + "VALUES ( '" + id + "', "
                    + " '" + reservation.getClient().getId() + "', "
                    + " '" + reservation.getVehicule().getMatricule() + "', "
                    + " '" + reservation.getDateDebut() + "', "
                    + " '" + reservation.getDateFin() + "', "
                    + " '" + reservation.getPrixTotal() + "')";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Reservation reservation) {

        try {

            sql = "UPDATE reservation "
                    + " SET "
                    + " date_debut = '" + reservation.getDateDebut() + "', "
                    + " date_fin = '" + reservation.getDateFin() + "', "
                    + " prix_total = '" + reservation.getPrixTotal() + "' "
                    + " WHERE id = '" + reservation.getId() + "'";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Reservation> readAll() {
        List<Reservation> reservations = new ArrayList<>();

        try {

            sql = "SELECT * FROM reservation";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Vehicule v = new Vehicule();

                if (new BusAPI().read(resultSet.getString(3)) != null) {
                    v = new BusAPI().read(resultSet.getString(3)).getVehicule();
                }

                if (new VoitureAPI().read(resultSet.getString(3)) != null) {
                    v = new VoitureAPI().read(resultSet.getString(3)).getVehicule();
                }

                Reservation r = new Reservation(
                        resultSet.getString(1),
                        new ClientAPI().read(resultSet.getString(2)),
                        v,
                        resultSet.getDate(4),
                        resultSet.getDate(5),
                        resultSet.getInt(6)
                );

                reservations.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reservations;
    }

    @Override
    public Reservation read(String id) {
        return new Reservation();
    }

    @Override
    public void delete(String id) {

        try {

            sql = "DELETE FROM reservation WHERE id = '" + id + "'";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
