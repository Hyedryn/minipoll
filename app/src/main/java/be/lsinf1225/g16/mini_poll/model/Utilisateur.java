package be.lsinf1225.g16.mini_poll.model;

import android.graphics.Bitmap;
import android.util.SparseArray;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;

import static be.lsinf1225.g16.mini_poll.MiniPollApp.connectedUser;
import static be.lsinf1225.g16.mini_poll.MiniPollApp.utilisateurs;

public class Utilisateur {





    /**
     * Identifiant unique de l'utilisateur courant. Correspond à _id dans la base de données.
     */
    private final String identifiant;
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

    private ArrayList<Sondage> sondages;

    private ArrayList<Utilisateur> amis;

    private ArrayList<Utilisateur> demandeAmis;

    private Bitmap photo;


    /**
     * Constructeur de Utilisateur
     */

    public Utilisateur(String uId, String uPassword, String uNom, String uPrenom, String uEmail, String uMeilleurAmi, Bitmap photo) {
        this(uId, uPassword, uNom, uPrenom, uEmail, uMeilleurAmi);
        this.photo = photo;
    }

    public Utilisateur(String uId, String uPassword, String uNom, String uPrenom, String uEmail, String uMeilleurAmi) {
        this(uId, uPassword, uNom);
        this.prenom = uPrenom;
        this.email = uEmail;
        this.meilleur_ami = uMeilleurAmi;
    }

    public Utilisateur(String uId, String uPassword) {
        this.identifiant=uId;
        this.password=uPassword;
    }

    public Utilisateur(String uId, String uPassword, String uNom) {
        this.identifiant=uId;
        this.password=uPassword;
        this.nom=uNom;
    }


    /*
    *  getter
     */
    public String getIdentifiant() {
        return this.identifiant;
    }
    public String getPassword() {
        return this.password;
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public String getEmail() {
        return this.email;
    }
    public String getMeilleur_ami() {
        return this.meilleur_ami;
    }

    public Bitmap getPhoto() { return this.photo; }

    //retourne un objet de type Utilisateur de l'ami dans la liste d'amis dont le nom correspond au nom passé en parametre
    public Utilisateur getAmi(String id) {
        if(this.amis==null)
            return null;

        for(Utilisateur ami : this.amis) {
            if(ami.getIdentifiant().equals(id)) {
                return ami;
            }
        }
        return null; //si ami n'existe pas dans la liste des amis, retourne null, est ce qu'il faut retourner autre chose?? provoque null pointer exception
    }

    //retourne le sondage dont la question correspond au string passé en parametre
    public Sondage getSondage(int id) {
        for(Sondage sondage : sondages) {
            if(sondage.getSondageId()==id)
                return sondage;
        }
        return null; //si pas trouvé dans la liste des sondages retourne null
    }

    /**
     * Setter
     */

    //pas de methode set pour identifiant parce que c'est un final int, ca sera un static augmente a chaque fois qu'on ajoute un utilisateur?
    public void setPassword(String password) {
        this.password=password;
    }
    public void setNom(String nom) {
        this.nom=nom;
    }
    public void setPrenom(String prenom) {
        this.prenom=prenom;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhoto(Bitmap photo){
        this.photo=photo;
    }

    //met la variable meilleurAmi à l'utilisateur (se trouvant deja dans la liste d'amis) dont l'id correspond au string passe en param
    public void setMeilleurAmi(String id) {

        for(Utilisateur ami : amis) {
            if(ami.getIdentifiant().equals(id)) {
                this.meilleur_ami=ami.getIdentifiant();
                break;
            }
        }
        MiniPollApp.saveUser(connectedUser);
    }


    //ajoute au tableau demandeAmis l'utilisateur dans la base de données dont le nom correspond au nom passé en parametre
    //NECESSITE INTERACTION AVEC BDD
    public void addDemandeAmi(String id) {
        for(Utilisateur demandeami : MiniPollApp.utilisateurs) {
            //si utilisateur exist l'ajouter
            if(demandeami.getIdentifiant().equals(id)) {
                demandeAmis.add(demandeami);
                break;
            }
        }
        MiniPollApp.saveUser(connectedUser);
    }

    //retire du tableau demandeAmis, l'utlisareur dont le nom correspond au nom passé en parametre
    public void removeDemandeAmi(String id) {
        for(Utilisateur demandeami : demandeAmis) {
            if(demandeami.getIdentifiant().equals(id)) {
                demandeAmis.remove(demandeami);
                break;
            }
        }
        MiniPollApp.saveUser(connectedUser);
    }



    //a completer
    /*public boolean isAccepted(Utilisateur ut1, Utilisateur ut2) {

    }*/

    //utilisation des tableaux dynamiques ici?
    //j'ai changé type de retour de sondage à void
    //necessite interaction avec base de données pour chercher un sondage avec id correspondant

    /*public void addSondage (int id) {

    }*/


    public boolean checkId(String id) {
            return id.equals(this.identifiant);
    }

    public boolean checkMdp(String mdp) {
        return mdp.equals(this.password);
    }

    public void changeStatut(Utilisateur ut) {

    }


    public boolean sameMdp(Utilisateur ut) {
        return this.getPassword().equals(ut.getPassword());
    }


    public static boolean utilisateurIsAvailable(String pseudo) {
        for(Utilisateur user : utilisateurs) {
            if(user.getIdentifiant().equals(pseudo)){
                return false;
            }
        }
        return true;
    }



}
