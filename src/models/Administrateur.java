package models;

public class Administrateur {

    private String id;
    private Utilisateur utilisateur;
    private String email;
    private String motDePasse;

    public Administrateur(String id, Utilisateur utilisateur, String email, String motDePasse) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Administrateur(Utilisateur utilisateur, String email, String motDePasse) {
        this.utilisateur = utilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    
    
    public Administrateur() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

     
}
