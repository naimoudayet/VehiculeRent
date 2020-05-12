package api;

import config.Database;
import dao.ClientDAO;
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
import models.Utilisateur;

public class ClientAPI implements ClientDAO {

    private Database db;
    private Connection connection;
    private Statement statement;

    private ResultSet resultSet;
    private String sql;

    public ClientAPI() {
        try {

            db = new Database();
            connection = db.openConnection();
            statement = connection.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Client client) {

        String id = UUID.randomUUID().toString();

        try {

            UtilisateurAPI utilisateurAPI = new UtilisateurAPI();

            String id_utilisateur = utilisateurAPI.create(client.getUtilisateur());

            sql = "INSERT INTO client(id, id_utilisateur)"
                    + "VALUES ( '" + id + "', "
                    + " '" + id_utilisateur + "')";

            statement.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Client client) {
        new UtilisateurAPI().update(client.getUtilisateur());
    }

    @Override
    public void delete(Client client) {
        new UtilisateurAPI().delete(client.getUtilisateur().getId());
    }

    @Override
    public List<Client> readAll() {
        List<Client> clients = new ArrayList<>();

        try {

            sql = "SELECT c.id as id_client, u.* FROM client c, utilisateur u WHERE c.id_utilisateur = u.id ORDER BY u.nom ASC";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Client c = new Client(
                        resultSet.getString(1),
                        new Utilisateur(
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6)
                        )
                );

                clients.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clients;
    }

    @Override
    public Client read(String id) {
        Client client = null;

        try {

            sql = "SELECT c.id as id_client, u.* FROM client c, utilisateur u "
                    + "WHERE c.id_utilisateur = u.id AND c.id = '" + id + "' "
                    + "ORDER BY u.nom ASC";

            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                client = new Client(
                        resultSet.getString(1),
                        new Utilisateur(
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6)
                        )
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return client;
    }

}
