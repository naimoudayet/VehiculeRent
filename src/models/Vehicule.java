package models;

public class Vehicule {

    private String matricule; // -- TN ----
    private String marque;
    private String modele;
    private String puissance;
    private String assurance;
    private int prixJour;
    private int penalisationJour;

    public Vehicule(String matricule, String marque, String modele, String puissance, String assurance, int prixJour, int penalisationJour) {
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.assurance = assurance;
        this.prixJour = prixJour;
        this.penalisationJour = penalisationJour;
    }

    public Vehicule(String matricule) {
        this.matricule = matricule;
    }
 
    public Vehicule() {
    }
  
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public int getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(int prixJour) {
        this.prixJour = prixJour;
    }

    public int getPenalisationJour() {
        return penalisationJour;
    }

    public void setPenalisationJour(int penalisationJour) {
        this.penalisationJour = penalisationJour;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "matricule=" + matricule + ", marque=" + marque + ", modele=" + modele + ", puissance=" + puissance + ", assurance=" + assurance + ", prixJour=" + prixJour + ", penalisationJour=" + penalisationJour + '}';
    }

}
