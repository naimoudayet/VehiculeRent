package models;

public class Bus {

    private String id;
    private Vehicule vehicule;
    private int capacite;

    public Bus(String id, Vehicule vehicule, int capacite) {
        this.id = id;
        this.vehicule = vehicule;
        this.capacite = capacite;
    }

    public Bus(Vehicule vehicule, int capacite) {
        this.vehicule = vehicule;
        this.capacite = capacite;
    }

    public Bus() {
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

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Bus{" + "id=" + id + ", vehicule=" + vehicule.toString()
                + ", capacite=" + capacite + '}';
    }

}
