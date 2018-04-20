package be.lsinf1225.g16.mini_poll.model;

public class Utilisateur {

    /**
     * Identifiant unique de l'utilisateur courant. Correspond à _id dans la base de données.
     */
    private final int identifiant;
    /**
     * Nom (unique) de l'utilisateur courant. Correspond à u_nom dans la base de données.
     */
    private String nom;
    /**
     * Mot de passe de l'utilisateur courant. Correspond à u_password dans la base de données.
     */
    private String password;

    private String prenom;

    private String email;

    private String meilleur_ami;

    private Sondage[] sondages;

    private Utilisateur[] amis;

    private Utilisateur[] demandeAmis;




    private Utilisateur(int uId, String uPassword, String uNom, String uPrenom, String uEmail) {

        this.identifiant = uId;
        this.nom = uNom;
        this.password = uPassword;
        this.prenom = uPrenom;
        this.email = uEmail;
    }

}
