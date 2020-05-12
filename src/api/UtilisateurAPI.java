package api;

import config.Database;
import dao.UtilisateurDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Utilisateur;

public class UtilisateurAPI implements UtilisateurDAO {

    private Database db;
    private Connection connection;
    private Statement statement;
 
    private String sql;

    public UtilisateurAPI() {
        try {

            db = new Database();
            connection = db.openConnection();
            statement = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String create(Utilisateur utilisateur) {

        String id_utilisateur = UUID.randomUUID().toString();

        try {

            sql = "INSERT INTO utilisateur(id, num_cin, nom, prenom, num_tel)"
                    + "VALUES ( '" + id_utilisateur + "', "
                    + " '" + utilisateur.getNumCin() + "', "
                    + " '" + utilisateur.getNom() + "', "
                    + " '" + utilisateur.getPrenom() + "', "
                    + " '" + utilisateur.getNumTel() + "')";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id_utilisateur;
    }

    @Override
    public void update(Utilisateur utilisateur) {
        try {

            sql = "UPDATE utilisateur SET "
                    + " nom = '" + utilisateur.getNom() + "', "
                    + " prenom = '" + utilisateur.getPrenom() + "', "
                    + " num_cin = '" + utilisateur.getNumCin() + "', "
                    + " num_tel = '" + utilisateur.getNumTel() + "' "
                    + " WHERE id = '" + utilisateur.getId() + "'";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {

            sql = "DELETE FROM utilisateur WHERE id = '" + id + "'";
            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
