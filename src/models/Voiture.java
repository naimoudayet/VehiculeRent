package models;

public class Voiture {

    private String id;
    private Vehicule vehicule;

    public Voiture(String id, Vehicule vehicule) {
        this.id = id;
        this.vehicule = vehicule;
    }

    public Voiture(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Voiture() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return "Bus{" + "id=" + id + ", vehicule=" + vehicule.toString() + '}';
    }

}
