package api;

import config.Database;
import dao.AdministrateurDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Administrateur;

public class AdministrateurAPI implements AdministrateurDAO {

    private Database db;
    private Connection connection;
    private Statement statement;

    private ResultSet resultSet;
    private String sql;

    public AdministrateurAPI() {
        try {

            db = new Database();
            connection = db.openConnection();
            statement = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean login(Administrateur administrateur) {

        try {
            sql = "SELECT u.* FROM administrateur a, utilisateur u "
                    + " WHERE a.email = '" + administrateur.getEmail()
                    + "' AND a.mot_de_passe = '" + administrateur.getMotDePasse() + "'";

            resultSet = statement.executeQuery(sql);

            /*if( resultSet.next ){
                return true;
            }else{
                return false;
            }*/
            return resultSet.next();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public void create(Administrateur administrateur) {

        String id = UUID.randomUUID().toString();

        try {

            String id_utilisateur = new UtilisateurAPI().create(administrateur.getUtilisateur());

            sql = "INSERT INTO administrateur(id, id_utilisateur, email, mot_de_passe)"
                    + "VALUES ( '" + id + "', "
                    + " '" + id_utilisateur + "', "
                    + " '" + administrateur.getEmail() + "', "
                    + " '" + administrateur.getMotDePasse() + "' )";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
