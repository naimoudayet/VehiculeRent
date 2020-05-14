package utils;

import api.AdministrateurAPI;
import api.BusAPI;
import api.ClientAPI;
import api.ReservationAPI;
import api.UtilisateurAPI;
import api.VehiculeAPI;
import api.VoitureAPI;
import java.util.List;
import models.Administrateur;
import models.Bus;
import models.Client;
import models.Utilisateur;
import models.Vehicule;
import models.Voiture;

public class Seeder {

    public static void main(String[] args) {

        // add admin
        new AdministrateurAPI().create(
                new Administrateur(
                        new Utilisateur("12345678", "admin", "admin", "98765432"),
                        "admin@gmail.com",
                        "admin"
                )
        );

        // add clients
        for (int i = 0; i < 10; i++) {
            new ClientAPI().create(
                    new Client(
                            new Utilisateur("1234560" + i, "client" + i, "client" + i, "9876540" + i)
                    )
            );
        }

        // add Bus
        for (int i = 0; i < 5; i++) {
            new BusAPI().create(
                    new Bus(
                            new Vehicule("11" + i + "TN124" + i, "Marque " + i, "Modele " + i, "Puissance " + i, "Assurance",
                                    i, i),
                            50
                    )
            );

        }

        // add Voiture
        for (int i = 5; i < 10; i++) {

            new VoitureAPI().create(
                    new Voiture(
                            new Vehicule("11" + i + "TN124" + i, "Marque " + i, "Modele " + i, "Puissance " + i, "Assurance",
                                    i, i)
                    )
            );

        }

    }
}
