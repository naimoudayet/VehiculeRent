package utils;

import api.AdministrateurAPI;
import api.ClientAPI;
import api.UtilisateurAPI;
import java.util.List;
import models.Administrateur;
import models.Client;
import models.Utilisateur;

public class Seeder {

    public static void main(String[] args) {

        // add admin
        AdministrateurAPI adminAPI = new AdministrateurAPI();
        /*
        adminAPI.create(
                new Administrateur(
                        new Utilisateur("12345678", "admin", "admin", "98765432"),
                        "admin@gmail.com",
                        "admin"
                )
        );*/

        // login
        /*Administrateur admin = new Administrateur();
        admin.setEmail("admin@gmail.com");
        admin.setMotDePasse("admin");
        boolean isAuthorized = adminAPI.login(admin);
        System.out.println(isAuthorized);*/
        // gestion client:
        ClientAPI clientAPI = new ClientAPI();
        // add client:
        /*
         */

 /*for (int i = 0; i < 10; i++) {
            clientAPI.create(
                    new Client(
                            new Utilisateur("1234560" + i, "client" + i, "client" + i, "9876540" + i)
                    )
            );
        }*/
        // update client:
        /*clientAPI.update(new Client(
                new Utilisateur("82efd3bb-3b8e-4dea-bc17-d4970350988c", "12365478", "client", "client", "22222222")
        ));*/
        // delete client
        /*clientAPI.delete(new Client(
                new Utilisateur("82efd3bb-3b8e-4dea-bc17-d4970350988c", "12365478", "client", "client", "22222222")
        ));*/
        // read all
        /*List<Client> clients = clientAPI.readAll();

        for (Client c : clients) {
            System.out.println("Client: " + c.toString());
        }*/
        // read
        System.out.println("Client: " + clientAPI.read("8f437b05-6e4b-4ddf-b584-3f8c8fde0469"));
    }
}
