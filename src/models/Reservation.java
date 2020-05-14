package models;

import java.util.Date;

public class Reservation {

    private String id;
    private Client client;
    private Vehicule vehicule;
    private Date dateDebut;
    private Date dateFin;
    private int prixTotal;

    public Reservation(String id, Client client, Vehicule vehicule, Date dateDebut, Date dateFin, int prixTotal) {
        this.id = id;
        this.client = client;
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
    }

    public Reservation(Client client, Vehicule vehicule, Date dateDebut, Date dateFin, int prixTotal) {
        this.client = client;
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = prixTotal;
    }

    public Reservation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", client=" + client.toString() + ", vehicule=" + vehicule.toString() + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prixTotal=" + prixTotal + '}';
    }

     
}
