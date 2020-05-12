package models;

public class Utilisateur {

    private String id;
    private String numCin;
    private String nom;
    private String prenom;
    private String numTel;

    public Utilisateur(String id, String numCin, String nom, String prenom, String numTel) {
        this.id = id;
        this.numCin = numCin;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
    }
    
    public Utilisateur(String numCin, String nom, String prenom, String numTel) {
        this.numCin = numCin;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
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

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", numCin=" + numCin + ", nom=" + nom + ", prenom=" + prenom + ", numTel=" + numTel + '}';
    }

   
}
