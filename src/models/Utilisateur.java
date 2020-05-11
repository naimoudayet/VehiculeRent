package models;

public class Utilisateur {

    private String id;
    private String numCin;
    private String nom;
    private String prenom;
    private String num_Tel;

    public Utilisateur(String id, String numCin, String nom, String prenom, String num_Tel) {
        this.id = id;
        this.numCin = numCin;
        this.nom = nom;
        this.prenom = prenom;
        this.num_Tel = num_Tel;
    }

    public Utilisateur() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCin() {
        return numCin;
    }

    public void setNumCin(String numCin) {
        this.numCin = numCin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum_Tel() {
        return num_Tel;
    }

    public void setNum_Tel(String num_Tel) {
        this.num_Tel = num_Tel;
    }

}
