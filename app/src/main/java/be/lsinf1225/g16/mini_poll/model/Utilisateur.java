package be.lsinf1225.g16.mini_poll.model;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.MySQLiteHelper;
import be.lsinf1225.g16.mini_poll.R;

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
    public String getMeilleurAmi() {
        return this.meilleur_ami;
    }
    public ArrayList<Utilisateur> getListAmi(){
        if(amis==null)
            amis = new ArrayList<Utilisateur>();

        return amis;
    }
    public ArrayList<Utilisateur> getListDemandeAmi(){ return demandeAmis;}

    public ArrayList<Sondage> getSondages() {
        return sondages;
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

    public void setSondages(ArrayList<Sondage> sondages) {
        this.sondages = sondages;
    }

    /**
     * Setter
     */

    //pas de methode set pour identifiant parce que c'est un final String

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
    }

    public void addSondage(Sondage s){
        if(sondages==null)
            sondages=new ArrayList<Sondage>();
        sondages.add(s);
    }

    public void addDemandeAmi(String id) {
        for(Utilisateur demandeami : MiniPollApp.utilisateurs) {
            //si utilisateur existe l'ajouter
            if(demandeami.getIdentifiant().equals(id)) {
                if(demandeAmis==null)
                    demandeAmis=new ArrayList<>();
                addDemandeAmi(demandeami);
                break;
            }
        }
    }

    public void addDemandeAmi(Utilisateur u) {
        if(demandeAmis==null)
            demandeAmis=new ArrayList<>();
        if(u.equals(this))
            return;
        for(Utilisateur dami : this.demandeAmis) {
            //si utilisateur existe deja exit
            if(dami.equals(u)) {
                return;
            }
        }

        demandeAmis.add(u);

        final String DB_COLUMN_ID_1 = "identifiant_1";
        final String DB_COLUMN_ID_2 = "identifiant_2";
        final String DB_COLUMN_STATUT = "statut";
        final String DB_TABLE = "liste_amis";

        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_ID_1, u.getIdentifiant());
        values.put(DB_COLUMN_ID_2, this.getIdentifiant());
        values.put(DB_COLUMN_STATUT, "en cours");

        try{
            db.insert(DB_TABLE, null, values);
        }catch (SQLException e){
            MiniPollApp.notifyLong(R.string.error_unknown);
        }

        db.close();
    }

    //retire du tableau demandeAmis, l'utlisareur dont le nom correspond au nom passé en parametre
    public void removeDemandeAmi(String id) {
        if(demandeAmis==null)
            return;
        for(Utilisateur demandeami : demandeAmis) {
            if(demandeami.getIdentifiant().equals(id)) {
                removeDemandeAmi(demandeami);
                break;
            }
        }
    }

    public void removeDemandeAmi(Utilisateur u) {
        if(demandeAmis==null)
            return;

        demandeAmis.remove(u);

        final String DB_COLUMN_ID_1 = "identifiant_1";
        final String DB_COLUMN_ID_2 = "identifiant_2";
        final String DB_COLUMN_STATUT = "statut";
        final String DB_TABLE = "liste_amis";

        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        try{
            db.delete(DB_TABLE, DB_COLUMN_ID_1+"= '"+u.getIdentifiant()+"' AND "+DB_COLUMN_ID_2+"= '"+this.getIdentifiant()+"' AND "+DB_COLUMN_STATUT+"= 'en cours'",null);
        }catch (SQLException e){
            MiniPollApp.notifyLong(R.string.error_unknown);
        }

        db.close();

    }

    public void removeAmi(String id) {
        if(amis==null)
            amis=new ArrayList<>();
        for(Utilisateur ami : amis) {
            if(ami.getIdentifiant().equals(id)) {
                removeAmi(ami);
                break;
            }
        }
    }

    public void removeAmi(Utilisateur u) {
        if(amis==null)
            amis=new ArrayList<>();
        amis.remove(u);

        final String DB_COLUMN_ID_1 = "identifiant_1";
        final String DB_COLUMN_ID_2 = "identifiant_2";
        final String DB_COLUMN_STATUT = "statut";
        final String DB_TABLE = "liste_amis";

        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        try{
            db.delete(DB_TABLE, DB_COLUMN_ID_1+"= '"+u.getIdentifiant()+"' AND "+DB_COLUMN_ID_2+"= '"+this.getIdentifiant()+"' AND "+DB_COLUMN_STATUT+"= 'accepte'",null);
        }catch (SQLException e){
            MiniPollApp.notifyLong(R.string.error_unknown);
        }
    }

    public void addAmi(Utilisateur u) {
        if(u.equals(this))
            return;
        if(amis==null)
            amis=new ArrayList<>();
        for(Utilisateur ami : this.amis) {
            //si utilisateur existe l'ajouter
            if(ami.equals(u)) {
                return;
            }
        }

        amis.add(u);

        final String DB_COLUMN_ID_1 = "identifiant_1";
        final String DB_COLUMN_ID_2 = "identifiant_2";
        final String DB_COLUMN_STATUT = "statut";
        final String DB_TABLE = "liste_amis";

        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_ID_1, u.getIdentifiant());
        values.put(DB_COLUMN_ID_2, this.getIdentifiant());
        values.put(DB_COLUMN_STATUT, "accepte");

        try{
            db.insert(DB_TABLE, null, values);
        }catch (SQLException e){
            MiniPollApp.notifyLong(R.string.error_unknown);
        }

        db.close();
    }

    public void addAmi(String id) {
        for(Utilisateur ami : MiniPollApp.utilisateurs) {
            //si utilisateur existe l'ajouter
            if(ami.getIdentifiant().equals(id)) {
                if(amis==null)
                    amis=new ArrayList<>();
                addAmi(ami);
                break;
            }
        }
    }


    public boolean checkMdp(String mdp) {
        return mdp.equals(this.password);
    }

    public static boolean utilisateurIsAvailable(String pseudo) {
        for(Utilisateur user : utilisateurs) {
            if(user.getIdentifiant().equals(pseudo)){
                return false;
            }
        }
        return true;
    }

    /**
     * Never used methods
    public boolean checkId(String id) {
        return id.equals(this.identifiant);
    }

    public void addSondage(Sondage sondage){
        this.sondages.add(sondage);
    }
    public boolean sameMdp(Utilisateur ut) {
        return this.getPassword().equals(ut.getPassword());}

     */

}
