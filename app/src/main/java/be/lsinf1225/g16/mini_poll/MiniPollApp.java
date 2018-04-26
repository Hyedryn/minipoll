package be.lsinf1225.g16.mini_poll;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import android.view.Gravity;
import android.widget.Toast;

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

    public boolean getSpecialCharacterCount(String s) {
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Incorrect format of string");
            return false;
        }
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(s);
        // boolean b = m.matches();
        boolean b = m.find();
        return b;
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

    public static void loadFriendOfConnectedUser(){

    }


    public  static void saveUser(Utilisateur u){

    }

    public  static void updateID(String id){
        Utilisateur user = new Utilisateur(id, connectedUser.getPassword(), connectedUser.getNom(), connectedUser.getPrenom(), connectedUser.getEmail(), connectedUser.getMeilleur_ami(), connectedUser.getPhoto());
        saveUser(user);
        //editDatabase
        loadUtilisateurs();
        loadFriendOfConnectedUser();
        connectedUser = user;
    }



    public static void loadUtilisateurs() {
    /**    // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        // Colonnes à récupérer
        String[] colonnes = {DB_COLUMN_ID, DB_COLUMN_NAME, DB_COLUMN_PASSWORD};

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

            String uMeilleurAmi = cursor.getString(6);

            // Creation d'une instance de l'utilisateur.
            Utilisateur user =  new Utilisateur(uId, uPassword, uNom, uPrenom, uEmail, uMeilleurAmi);


            // Ajout de l'utilisateur à la liste.
            users.add(user);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close(); **/
        ArrayList<Utilisateur> users = new ArrayList<>();
        users.add(new Utilisateur("qdessain", "mdp", "Dessain", "Quentin", "quentin124@hotmail.be", ""));
        users.add(new Utilisateur("Fred", "mdp", "ver", "Fred", "freddy@gmx.com", ""));
        utilisateurs = users;

    }
}


