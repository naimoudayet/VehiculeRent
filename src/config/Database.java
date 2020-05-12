package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DB_NAME = "vehicule_rent";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";

    public Connection openConnection() {

        Connection connection = null;

        try {

            Class.forName(DRIVER);

            connection = DriverManager.
                    getConnection(
                            URL + DB_NAME,
                            USERNAME,
                            PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return connection;
    }

}
