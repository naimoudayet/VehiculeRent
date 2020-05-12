package api;

import config.Database;
import dao.VehiculeDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Vehicule;

public class VehiculeAPI implements VehiculeDAO {

    private Database db;
    private Connection connection;
    private Statement statement;

    private String sql;

    public VehiculeAPI() {
        try {

            db = new Database();
            connection = db.openConnection();
            statement = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Vehicule vehicule) {

        try {

            sql = "INSERT INTO vehicule(matricule, marque, modele, puissance, assurance, prix_jour, penalisation_jour) "
                    + "VALUES ( '" + vehicule.getMatricule() + "',"
                    + " '" + vehicule.getMarque() + "',"
                    + " '" + vehicule.getModele() + "',"
                    + " '" + vehicule.getPuissance() + "', "
                    + " '" + vehicule.getAssurance() + "', "
                    + " '" + vehicule.getPrixJour() + "' , "
                    + " '" + vehicule.getPenalisationJour() + "')";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Vehicule vehicule) {
        try {

            sql = "UPDATE vehicule "
                    + " SET matricule = '" + vehicule.getMatricule() + "',"
                    + " marque = '" + vehicule.getMarque() + "',"
                    + " modele = '" + vehicule.getModele() + "',"
                    + " puissance = '" + vehicule.getPuissance() + "', "
                    + " assurance = '" + vehicule.getAssurance() + "', "
                    + " prix_jour = '" + vehicule.getPrixJour() + "' , "
                    + " penalisation_jour = '" + vehicule.getPenalisationJour() + "' "
                    + " WHERE matricule = '" + vehicule.getMatricule() + "'";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String matricule) {
        try {

            sql = "DELETE FROM vehicule "
                    + " WHERE matricule = '" + matricule + "'";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
