package api;

import config.Database;
import dao.VoitureDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Vehicule;
import models.Voiture;

public class VoitureAPI implements VoitureDAO {

    private Database db;
    private Connection connection;
    private Statement statement;

    private ResultSet resultSet;
    private String sql;

    public VoitureAPI() {
        try {

            db = new Database();
            connection = db.openConnection();
            statement = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Voiture voiture) {

        String id = UUID.randomUUID().toString();

        try {

            new VehiculeAPI().create(voiture.getVehicule());

            sql = "INSERT INTO voiture(id, matricule)"
                    + "VALUES ( '" + id + "', "
                    + " '" + voiture.getVehicule().getMatricule() + "')";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Voiture voiture) {
        new VehiculeAPI().update(voiture.getVehicule());
    }

    @Override
    public void delete(Voiture voiture) {
        new VehiculeAPI().delete(voiture.getVehicule().getMatricule());
    }

    @Override
    public List<Voiture> readAll() {
        List<Voiture> voitures = new ArrayList<>();

        try {

            sql = "SELECT vo.id, ve.* FROM voiture vo, vehicule ve WHERE vo.matricule = ve.matricule ORDER BY ve.matricule ASC";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Voiture v = new Voiture(
                        resultSet.getString(1),
                        new Vehicule(
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getInt(7),
                                resultSet.getInt(8)
                        )
                );

                voitures.add(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return voitures;
    }

    @Override
    public Voiture read(String id) {
        Voiture voiture = null;

        try {

            sql = "SELECT vo.id, ve.* FROM voiture vo, vehicule ve WHERE vo.matricule = ve.matricule AND vo.id = '" + id + "'";

            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                voiture = new Voiture(
                        resultSet.getString(1),
                        new Vehicule(
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getInt(7),
                                resultSet.getInt(8)
                        )
                );

            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return voiture;
    }

}
