package api;

import config.Database;
import dao.BusDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Bus;
import models.Vehicule;

public class BusAPI implements BusDAO {

    private Database db;
    private Connection connection;
    private Statement statement;

    private ResultSet resultSet;
    private String sql;

    public BusAPI() {
        try {

            db = new Database();
            connection = db.openConnection();
            statement = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Bus bus) {

        String id = UUID.randomUUID().toString();

        try {

            new VehiculeAPI().create(bus.getVehicule());

            sql = "INSERT INTO bus(id, matricule, capacite)"
                    + "VALUES ( '" + id + "', "
                    + " '" + bus.getVehicule().getMatricule() + "', "
                    + " '" + bus.getCapacite() + "')";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Bus bus) {

        try {

            new VehiculeAPI().update(bus.getVehicule());

            sql = "UPDATE bus SET capacite = '" + bus.getCapacite() + "' WHERE id = '" + bus.getId() + "'";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Bus bus) {
        new VehiculeAPI().delete(bus.getVehicule().getMatricule());
    }

    @Override
    public List<Bus> readAll() {
        List<Bus> bus = new ArrayList<>();

        try {

            sql = "SELECT b.id, b.capacite, v.* FROM bus b, vehicule v WHERE b.matricule = v.matricule ORDER BY matricule ASC";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Bus b = new Bus(
                        resultSet.getString(1),
                        new Vehicule(
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getInt(8),
                                resultSet.getInt(9)
                        ),
                        resultSet.getInt(2)
                );

                bus.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bus;
    }

    @Override
    public Bus read(String id) {
        Bus bus = null;

        try {

            sql = "SELECT b.id, b.capacite, v.* FROM bus b, vehicule v WHERE b.matricule = v.matricule AND b.id = '" + id + "'";

            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                bus = new Bus(
                        resultSet.getString(1),
                        new Vehicule(
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getInt(8),
                                resultSet.getInt(9)
                        ),
                        resultSet.getInt(2)
                );

            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bus;
    }

}
