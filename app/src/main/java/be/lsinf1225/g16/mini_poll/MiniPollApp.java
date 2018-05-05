package be.lsinf1225.g16.mini_poll;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.model.Choix;
import be.lsinf1225.g16.mini_poll.model.Sondage;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class MiniPollApp extends Application {


    //ArrayList comprennant tout les utilisateurs de la database
    public static ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

    public static Utilisateur connectedUser;

    /**
     * Référence au contexte de l'application
     */
    private static MiniPollApp context;

    /**
     * Fournit le contexte de l'application.
     *
     * @return Contexte de l'application.
     */
    public static MiniPollApp getContext() {
        return context;
    }


    /**
     * Affiche une notification pendant une courte durée à l'utilisateur.
     *
     * @param resId Id de la ressource (R.string.* ) contenant le message à afficher.
     * @see MiniPollApp#notify
     */
    public static void notifyShort(int resId) {
        notify(resId, Toast.LENGTH_SHORT);
    }

    /**
     * Affiche une notification pendant une longue durée à l'utilisateur.
     *
     * @param resId Id de la ressource (R.string.* ) contenant le message à afficher.
     * @see MiniPollApp#notify
     */
    public static void notifyLong(int resId) {
        notify(resId, Toast.LENGTH_LONG);
    }

    /**
     * Affiche une notification à l'utilisateur. Cette notification est centrée sur l'écran afin
     * qu'elle soit bien visible même lorsque le clavier est actif.
     *
     * @param resId    Id de la ressource (R.string.* ) contenant le message à afficher.
     * @param duration Durée d'affichage (Toast.LENGTH_SHORT ou Toast.LENGTH_LONG)
     */
    private static void notify(int resId, int duration) {
        Toast msg = Toast.makeText(getContext(), getContext().getString(resId), duration);
        msg.setGravity(Gravity.CENTER, 0, 0);
        msg.show();
    }

    public void onCreate() {
        super.onCreate();
        context = (MiniPollApp) getApplicationContext();
        loadUtilisateurs();
    }


    /**
     * Class global statique
     */

    public static boolean isValidCharacterNoSpace(String s) {
        int upperCases = s.replaceAll("[^A-Z]", "").length();
        int lowerCases = s.replaceAll("[^a-z]", "").length();
        int digits = s.replaceAll("[^0-9]", "").length();
        int specialChars = s.replaceAll("[^-@#$€!_?&èàéùôêâî.,]", "").length();
        // As '-' is a range operator otherwise, start the group with it.
        int all = s.length();
        return upperCases + lowerCases + digits + specialChars == all;
    }

    public static boolean isValidCharacter(String s) {
        int upperCases = s.replaceAll("[^A-Z]", "").length();
        int lowerCases = s.replaceAll("[^a-z]", "").length();
        int digits = s.replaceAll("[^0-9]", "").length();
        int specialChars = s.replaceAll("[^-@#$€!_?&è àéùôêâî.,]", "").length();
        // As '-' is a range operator otherwise, start the group with it.
        int all = s.length();
        return upperCases + lowerCases + digits + specialChars == all;
    }

    /**
     * INTERACTION AVEC LA BASE DE DONNEE
     */

    public static void loadConnectedUser() {

        //Charge les amis

        // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();


        final String DB_COLUMN_ID_1 = "identifiant_1";
        final String DB_COLUMN_ID_2 = "identifiant_2";
        final String DB_COLUMN_STATUT = "statut";
        final String DB_TABLE = "liste_amis";


        // Colonnes à récupérer
        String[] colonnes = {DB_COLUMN_ID_1, DB_COLUMN_ID_2, DB_COLUMN_STATUT};

        // Requête de selection (SELECT)
        Cursor cursor = db.query(DB_TABLE, colonnes, null, null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursor.moveToFirst();

        // Initialisation la liste des utilisateurs.
        ArrayList<Utilisateur> users = new ArrayList<>();

        // Tant qu'il y a des lignes.
        while (!cursor.isAfterLast()) {
            // Récupération des informations de l'utilisateur pour chaque ligne.
            String uID_1 = cursor.getString(0);
            String uID_2 = cursor.getString(1);
            String uStatut = cursor.getString(2);

            if (uID_1.equals(connectedUser.getIdentifiant()) && uStatut.equals("accepte")) {
                connectedUser.addAmi(uID_2);
            } else if (uID_2.equals(connectedUser.getIdentifiant()) && uStatut.equals("accepte")) {
                connectedUser.addAmi(uID_1);
            } else if (uID_2.equals(connectedUser.getIdentifiant()) && uStatut.equals("en cours")) {
                connectedUser.addDemandeAmi(uID_1);
            }
            // connecteduser à demande à uID_2
            //    else if(uID_1.equals(connectedUser.getIdentifiant())&&uStatut.equals("en cours")){
            //        connectedUser.addDemandeAmi(uID_2);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close();
    }

    /**
     * But de la classe: charger tout les sondages lié à l'utilisateur ConnectedUser
     * <p>
     * Etape:
     * 1) Chargé les id des participants qui participe au même sondage que la personne OK
     * 2) Chargé les sondages à proprement parlé OK
     * 3) Chargé les questions des sondages
     * 4) Chargé les réponses des sondages
     * 5) Chargé les choix effectué par les utilisateurs
     */
    private static void loadSondage() {


        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        final String DB_COLUMN_ID_P = "identifiant";
        final String DB_COLUMN_ID_SONDAGE_P = "ID_sondage";
        final String DB_COLUMN_STATUT_P = "statut";
        final String DB_TABLE_P = "liste_participants";


        // Colonnes à récupérer
        String[] colonnes = {DB_COLUMN_ID_P, DB_COLUMN_ID_SONDAGE_P, DB_COLUMN_STATUT_P};


        // Requête de selection (SELECT)
        Cursor cursorP = db.query(DB_TABLE_P, colonnes, "identifiant" + "= " + "'" + connectedUser.getIdentifiant() + "'", null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursorP.moveToFirst(); //we have a pointer to the first record

        // Initialisation la liste des utilisateurs.
        ArrayList<Choix> choix = new ArrayList<>();

        // Tant qu'il y a des lignes.
        while (!cursorP.isAfterLast()) {
            // Récupération des informations de l'utilisateur pour chaque ligne.
            String uID = cursorP.getString(0);
            int uID_Sondage = Integer.parseInt(cursorP.getString(1));
            String uStatut = cursorP.getString(2);

            if (uID.equals(connectedUser.getIdentifiant())) {
                Choix c_choix = new Choix(connectedUser, uID_Sondage, uStatut); //here we use second constructor method with identifiant, sondage if and status responded or not
                choix.add(c_choix);
            }

            // Passe à la ligne suivante.
            cursorP.moveToNext();
        }

        // Placement du curseur sur la première ligne.
        cursorP.moveToFirst(); //cursor still on liste_participants

        //Chargement des participants du même Sondage

        // Tant qu'il y a des lignes.
        while (!cursorP.isAfterLast()) {
            // Récupération des informations de l'utilisateur pour chaque ligne.
            String uID = cursorP.getString(0);
            int uID_Sondage = Integer.parseInt(cursorP.getString(1));
            String uStatut = cursorP.getString(2);

            Choix c_choix = null;
            for (Choix c : choix) {
                if (!uID.equals(connectedUser.getIdentifiant()) && uID_Sondage == c.getSondageID()) { //look at all users whose name is not
                    //the same as connected user but the sondage id is the same as connected user
                    c_choix = new Choix(uID, uID_Sondage, uStatut);
                }
            }

            if (c_choix != null)
                choix.add(c_choix);

            // Passe à la ligne suivante.
            cursorP.moveToNext();
        }

        //At this point we have connected user's info and all of the other users that participate in the same sondage
        //Now we need to get the information about all polls in the choix arraylist
        //need to access table sondage in database

        // Fermeture du curseur
        cursorP.close();

        final String DB_COLUMN_CREATEUR = "createur";

        String[] colonnes2 = {DB_COLUMN_ID_SONDAGE_P, DB_COLUMN_CREATEUR, DB_COLUMN_STATUT_P};

        Cursor cursorA = db.query("sondage", colonnes2, null, null, null, null, null);

        cursorA.moveToFirst();

        ArrayList<Sondage> sondages = new ArrayList<Sondage>();

        while (!cursorA.isAfterLast()) {
        int uID_Sondage = cursorA.getInt(0);
        String uCreateur = cursorA.getString(1);
        String uStatut = cursorP.getString(2);
        Utilisateur createur = null;

        for (Utilisateur u : utilisateurs) { //on cherche l'utilisateur qui correspond a l'identifiant du createur dans la bdd
            if (u.getIdentifiant().equals(uCreateur)) {
                createur = u;
            }
        }
        Sondage sondage_s = null;

        for (Choix c : choix) {
            if (uID_Sondage == c.getSondageID() && createur != null) {
                sondage_s = new Sondage(uID_Sondage, createur, uStatut);
            }
        }

        if (sondage_s != null)
            sondages.add(sondage_s);

        // Passe à la ligne suivante.
        cursorA.moveToNext();
    }
     //We now have basic sondage info in arraylist sondage (id, createur, statut ), need to add liste participants for each one, info already in choix
    for(Choix c : choix){
            for(Sondage s : sondages){
                ArrayList<Utilisateur> participants=new ArrayList<Utilisateur>();
                s.setListeParticipants(participants);
                if(c.getSondageID()==s.getSondageId()){
                    participants.add(c.getParticipant());
                }
            }
    }
    cursorA.close();
    //Info in sondages: id, createur, statut, liste de participants

    //Need to go to table contenu to find type information
     String[]colonnes3={"ID_sondage","type"};
     Cursor cursorB = db.query("contenu",colonnes3, null, null, null, null, null);

     cursorB.moveToFirst();

     while (!cursorB.isAfterLast()) {
        int uID_Sondage=cursorB.getInt(0);
        String type=cursorB.getString(1);
             for(Sondage s : sondages){
                if(s.getSondageId()==uID_Sondage){
                    s.setType(type);
                }
         }
         cursorB.moveToNext();
     }
        db.close();
}





    public static void saveUser(Utilisateur u){

        final String DB_COLUMN_ID = "identifiant";
        final String DB_COLUMN_MAIL = "mail";
        final String DB_COLUMN_NAME = "nom";
        final String DB_COLUMN_SURNAME = "prenom";
        final String DB_COLUMN_PASSWORD = "mdp";
        final String DB_COLUMN_PHOTO = "photo";
        final String DB_COLUMN_BEST_FRIEND = "meilleur_ami";
        final String DB_TABLE = "utilisateur";

        String[] colonnes = {DB_COLUMN_ID, DB_COLUMN_MAIL, DB_COLUMN_NAME, DB_COLUMN_SURNAME, DB_COLUMN_PASSWORD, DB_COLUMN_PHOTO, DB_COLUMN_BEST_FRIEND};

        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_MAIL, u.getEmail());
        values.put(DB_COLUMN_NAME, u.getNom());
        values.put(DB_COLUMN_SURNAME, u.getPrenom());
        values.put(DB_COLUMN_PASSWORD, u.getPassword());
        Bitmap photo = u.getPhoto();
        if(photo!=null){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, bos);
            byte[] bArray = bos.toByteArray();
            values.put(DB_COLUMN_PHOTO, bArray);
        }

        values.put(DB_COLUMN_BEST_FRIEND, u.getMeilleurAmi());
        try{
            db.update(DB_TABLE, values, "identifiant"+"= "+"'"+u.getIdentifiant()+"'", null);
        }catch (SQLException e){
            MiniPollApp.notifyLong(R.string.error_unknown);
        }
        db.close();
    }




    public  static void updateID(String id){
        Utilisateur user = new Utilisateur(id, connectedUser.getPassword(), connectedUser.getNom(), connectedUser.getPrenom(), connectedUser.getEmail(), connectedUser.getMeilleurAmi(), connectedUser.getPhoto());
       // saveUser(user);
        //editDatabase
        loadUtilisateurs();
        loadConnectedUser();
        connectedUser = user;
    }

    public static void saveNewUser(Utilisateur u){

        final String DB_COLUMN_ID = "identifiant";
        final String DB_COLUMN_MAIL = "mail";
        final String DB_COLUMN_NAME = "nom";
        final String DB_COLUMN_SURNAME = "prenom";
        final String DB_COLUMN_PASSWORD = "mdp";
        final String DB_COLUMN_PHOTO = "photo";
        final String DB_COLUMN_BEST_FRIEND = "meilleur_ami";
        final String DB_TABLE = "utilisateur";

        String[] colonnes = {DB_COLUMN_ID, DB_COLUMN_MAIL, DB_COLUMN_NAME, DB_COLUMN_SURNAME, DB_COLUMN_PASSWORD, DB_COLUMN_PHOTO, DB_COLUMN_BEST_FRIEND};

        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_ID, u.getIdentifiant());
        values.put(DB_COLUMN_MAIL, u.getEmail());
        values.put(DB_COLUMN_NAME, u.getNom());
        values.put(DB_COLUMN_SURNAME, u.getPrenom());
        values.put(DB_COLUMN_PASSWORD, u.getPassword());
        Bitmap photo = u.getPhoto();
        if(photo!=null){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, bos);
            byte[] bArray = bos.toByteArray();
            values.put(DB_COLUMN_PHOTO, bArray);
        }

        values.put(DB_COLUMN_BEST_FRIEND, u.getMeilleurAmi());

        db.insert(DB_TABLE, null, values);
        db.close();
    }

    public static void loadUtilisateurs() {
         // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();


        final String DB_COLUMN_ID = "identifiant";
        final String DB_COLUMN_MAIL = "mail";
        final String DB_COLUMN_NAME = "nom";
        final String DB_COLUMN_SURNAME = "prenom";
        final String DB_COLUMN_PASSWORD = "mdp";
        final String DB_COLUMN_PHOTO = "photo";
        final String DB_COLUMN_BEST_FRIEND = "meilleur_ami";
        final String DB_TABLE = "utilisateur";


        // Colonnes à récupérer
        String[] colonnes = {DB_COLUMN_ID, DB_COLUMN_MAIL, DB_COLUMN_NAME, DB_COLUMN_SURNAME, DB_COLUMN_PASSWORD, DB_COLUMN_PHOTO, DB_COLUMN_BEST_FRIEND};

        // Requête de selection (SELECT)
        Cursor cursor = db.query(DB_TABLE, colonnes, null, null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursor.moveToFirst();

        // Initialisation la liste des utilisateurs.
        ArrayList<Utilisateur> users = new ArrayList<>();

        // Tant qu'il y a des lignes.
        while (!cursor.isAfterLast()) {
            // Récupération des informations de l'utilisateur pour chaque ligne.
            String uId = cursor.getString(0);
            String uEmail = cursor.getString(1);
            String uNom = cursor.getString(2);
            String uPrenom = cursor.getString(3);
            String uPassword = cursor.getString(4);

            byte[] byteArrayPhoto = cursor.getBlob(5);

            String uMeilleurAmi = cursor.getString(6);

            // Creation d'une instance de l'utilisateur.
            Utilisateur user;
            if(byteArrayPhoto==null||byteArrayPhoto.length<10){
                user =  new Utilisateur(uId, uPassword, uNom, uPrenom, uEmail, uMeilleurAmi);
            }else{
                Bitmap bm = BitmapFactory.decodeByteArray(byteArrayPhoto, 0, byteArrayPhoto.length);
                user =  new Utilisateur(uId, uPassword, uNom, uPrenom, uEmail, uMeilleurAmi, bm.copy(bm.getConfig(), true));
            }
            // Ajout de l'utilisateur à la liste.
            users.add(user);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close();

        utilisateurs = users;

    }



    }
