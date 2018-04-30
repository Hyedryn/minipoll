package be.lsinf1225.g16.mini_poll;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;
import android.view.Gravity;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     *
     * @see MiniPollApp#notify
     */
    public static void notifyShort(int resId) {
        notify(resId, Toast.LENGTH_SHORT);
    }

    /**
     * Affiche une notification pendant une longue durée à l'utilisateur.
     *
     * @param resId Id de la ressource (R.string.* ) contenant le message à afficher.
     *
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
     *
     *
     * Class global statique
     *
     *
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
     *
     *
     *
     *
     *
     *
     *
     *
     */

    public static void loadConnectedUser(){

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

            if(uID_1.equals(connectedUser.getIdentifiant())&&uStatut.equals("accepte")){
                connectedUser.addAmi(uID_2);
            } else if(uID_2.equals(connectedUser.getIdentifiant())&&uStatut.equals("accepte")){
                connectedUser.addAmi(uID_1);
            }else if(uID_2.equals(connectedUser.getIdentifiant())&&uStatut.equals("en cours")){
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


        //todo: charge les sondages

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



        //ajout manuel d'utilisateur en plus
      /**  users.add(new Utilisateur("egio", "mdp", "Desin", "Quen", "quenti4@hotmail.be", ""));
        users.add(new Utilisateur("marc", "mdp", "verfrfrf", "Frfd", "fr@gmx.com", ""));
        users.add(new Utilisateur("nat", "mdp", "Dessa", "Qutin", "quentin124@mail.be", ""));
        users.add(new Utilisateur("pap", "mdp", "ver", "Fred", "freddy@gmx.com", ""));
        users.add(new Utilisateur("Fred", "mdp", "ver", "Fred", "freddy@gmx.com", ""));
        users.add(new Utilisateur("Peter", "cat", "Van Roy", "Peter", "peter_vanroy@uclouvain.be", "Oz"));
        users.add(new Utilisateur("qdessain", "mdp", "Dessain", "Quentin", "quentin124@hotmail.be", ""));**/

        utilisateurs = users;

    }
}