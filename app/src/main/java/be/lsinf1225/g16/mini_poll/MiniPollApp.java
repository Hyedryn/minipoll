package be.lsinf1225.g16.mini_poll;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.activity.ConnexionActivity;
import be.lsinf1225.g16.mini_poll.activity.MenuMainActivity;
import be.lsinf1225.g16.mini_poll.model.Choix;
import be.lsinf1225.g16.mini_poll.model.Participant;
import be.lsinf1225.g16.mini_poll.model.Question;
import be.lsinf1225.g16.mini_poll.model.Reponse;
import be.lsinf1225.g16.mini_poll.model.Sondage;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class MiniPollApp extends Application {

    public static int id_Main;

    //ArrayList comprennant tout les utilisateurs de la database
    public static ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

    public static int connect(String id, String password){
        for(Utilisateur user : MiniPollApp.utilisateurs) {

            if(user.getIdentifiant().equals(id)) {

                if(!user.checkMdp(password)) {
                    MiniPollApp.notifyShort(R.string.error_invalid_password);
                    return 1;
                }

                MiniPollApp.connectedUser = MiniPollApp.utilisateurs.get(MiniPollApp.utilisateurs.indexOf(user));
                MiniPollApp.loadConnectedUser();


                return 0;

            }
        }
        return 2;
    }

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



    public static int getPixelValue(Context context, int dimenId) {
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dimenId,
                resources.getDisplayMetrics()
        );
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

      loadSondage();
    }

    /**
     * But de la classe: charger tout les sondages lié à l'utilisateur ConnectedUser
     * <p>
     * Etape:
     * 1) Chargé les id des participants qui participe au même sondage que la personne OK
     * 2) Chargé les sondages à proprement parlé OK
     * 3) Chargé les questions des sondages OK
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
        ArrayList<Participant> part = new ArrayList<Participant>();

        // Tant qu'il y a des lignes.
        while (!cursorP.isAfterLast()) {
            // Récupération des informations de l'utilisateur pour chaque ligne.
            String uID = cursorP.getString(0);
            int uID_Sondage = Integer.parseInt(cursorP.getString(1));
            String uStatut = cursorP.getString(2);

            if (uID.equals(connectedUser.getIdentifiant())) {
                Participant p = new Participant(uID,uID_Sondage,uStatut); //here we use second constructor method with identifiant, sondage if and status responded or not
                part.add(p);
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

            Participant participant_p = null;
            for (Participant p : part) {
                if (!uID.equals(connectedUser.getIdentifiant()) && uID_Sondage == p.getSondageID()) {
                    participant_p = new Participant(uID, uID_Sondage, uStatut);
                }
            }

            if (participant_p != null)
                part.add(participant_p);

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
            String uStatut = cursorA.getString(2);
            Utilisateur createur = null;

            for (Utilisateur u : utilisateurs) { //on cherche l'utilisateur qui correspond a l'identifiant du createur dans la bdd
                if (u.getIdentifiant().equals(uCreateur)) {
                    createur = u;
                }
            }
            Sondage sondage_s = null;

            for (Participant p : part) {
                if (uID_Sondage == p.getSondageID() && createur != null) {
                    sondage_s = new Sondage(uID_Sondage, createur, uStatut);
                }
            }

            if (sondage_s != null)
                sondages.add(sondage_s);

            // Passe à la ligne suivante.
            cursorA.moveToNext();
        }
        //We now have basic sondage info in arraylist sondage (id, createur, statut ), need to add liste participants for each one, info already in choix
        for(Participant p : part){
            for(Sondage s : sondages){
                if(p.getSondageID()==s.getSondageId()){
                    s.addParticipants(p);
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

        cursorB.close();

        //Retrieve questions from table Question: all elements of this table are saved in arraylist of objects Question
        String[] colonnes4={"ID_question","enonce","nombreReponses"} ;
        Cursor cursorC = db.query("question", colonnes4, null,null, null, null, null);

        cursorC.moveToFirst();
        ArrayList<Question> questions = new ArrayList<Question>();
        while(!cursorC.isAfterLast()){
            int uQuestionId=cursorC.getInt(0);
            String uEnonce=cursorC.getString(1);
            int uNombreReponses=cursorC.getInt(1);

            Question q=null;
            q=new Question(uEnonce,uNombreReponses,null,uQuestionId);
            if(q!=null){questions.add(q);}

            cursorC.moveToNext();
        }

        cursorC.close();

        Cursor cursorD= db.rawQuery("select contenu.ID_question, sondage.ID_sondage from contenu," +
                "question,sondage where contenu.ID_question==question.ID_question and sondage.ID_sondage=contenu.ID_sondage " +
                "group by question.ID_question",null);


        System.out.println(" C ok");
        cursorD.moveToFirst();
        while(!cursorD.isAfterLast()){
            int Q=cursorD.getInt(0);
            int S=cursorD.getInt(1);

            for(Sondage s : sondages){
                for(Question q : questions){
                    if(S==s.getSondageId()&& Q==q.getQuestionId()){
                        s.addQuestion(q);
                    }
                }
            }
            cursorD.moveToNext();
        }

        cursorD.close();

        System.out.println(" D ok");

        Cursor cursorE= db.rawQuery("select reponse.ID_question, reponse.format, reponse.donnees, reponse.categorie, reponse.ID_reponse " +
                "from reponse,question where reponse.ID_question==question.ID_question order by reponse.ID_question;",null);
        cursorE.moveToFirst();

        while(!cursorE.isAfterLast()){
            int ID_question=cursorE.getInt(0);
            String reponse_format=cursorE.getString(1);
            String reponse_donnees=cursorE.getString(2);
            String reponse_cat=cursorE.getString(3);
            int reponse_id=cursorE.getInt(4);

            for(Sondage s : sondages){
                for(Question q : s.getQuestions()){
                    if(q.getQuestionId()==ID_question){
                        Reponse r=null;
                        r= new Reponse(reponse_id,reponse_cat,reponse_format,reponse_donnees);
                        if(r!=null){
                            q.addReponse(r);
                        }
                    }
                }
            }
            cursorE.moveToNext();
        }

        cursorE.close();

        System.out.println(" E ok");
        //On charge les choix des participants aux sondages, on les enregistre dans une ArrayList de choix pour chaque Participant de chaque Sondage

        Cursor cursorF=db.rawQuery("select ID_sondage,ID_question,ID_participant,score,ID_reponse from choix order by ID_sondage ;",null);
        cursorF.moveToFirst();
        while(!cursorF.isAfterLast()){
            int ID_sondage=cursorF.getInt(0);
            int ID_question=cursorF.getInt(1);
            String ID_participant=cursorF.getString(2);
            int score=cursorF.getInt(3);
            int ID_reponse=cursorF.getInt(4);

            for(Sondage s : sondages){
                for(Question q :s.getQuestions()){
                   for(Reponse r : q.getListeReponses()){
                       for(int i=0;i<s.getListeParticipants().size();i++) {
                           if (s.getSondageId() == ID_sondage && q.getQuestionId() == ID_question && r.getReponseId() == ID_reponse
                                   && s.getListeParticipants().get(i).getParticipant().getIdentifiant() == ID_participant) {
                                        Choix c = new Choix(r, score);
                                        if(c!=null){s.getListeParticipants().get(i).addChoix(c);}

                           }
                       }
                   }
                }
            }

        cursorF.moveToNext();

        }

        System.out.println(" F ok");
        cursorF.close();


        db.close();

        MiniPollApp.connectedUser.setSondages(sondages);
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
        //editDatabase pour que tout les anciens id soit remplacer par les nouveaux id
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



        String[] colonne = {"ID_MAIN"};
        Cursor cursorMain = db.query("id_static", colonne, null, null, null, null, null);
        cursorMain.moveToFirst();

        id_Main = cursorMain.getInt(0);
        cursor.close();

        db.close();

        utilisateurs = users;

    }

    public static void insertSondage(Sondage s, ArrayList<Participant> p,
                                     ArrayList<Question> q){

    //On ajoute les informations dans la table sondage: sondage id, createur, statut

        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        ContentValues values = new ContentValues();
        int sondageId=s.getSondageId();
        values.put("ID_sondage",s.getSondageId());
        values.put("createur",s.getCreateur().getIdentifiant());
        values.put("statut",s.getStateAsString());

        db.insert("sondage",null,values);

        ContentValues values_part = new ContentValues();

        for(Participant part : p){
            values_part.put("identifiant",part.getParticipant().getIdentifiant());
            values_part.put("ID_sondage",sondageId);
            values_part.put("statut",part.getStatusAsString());
            db.insert("liste_participants",null,values_part);
        }

        ContentValues values_quest = new ContentValues();

        for(Question quest : q){
            values_quest.put("ID_question",quest.getQuestionId());
            values_quest.put("enonce",quest.getEnonce());
            values_quest.put("nombreReponses",quest.getNbreReponses());
            db.insert("question",null,values_quest);
        }

        ContentValues values_rep = new ContentValues();
        for(Question quest : q){
            for(int i=0;i<quest.getListeReponses().size();i++){
                values_rep.put("ID_reponse",quest.getListeReponses().get(i).getReponseId());
                values_rep.put("ID_question",quest.getQuestionId());
                values_rep.put("format",quest.getListeReponses().get(i).getFormatAsString());
                values_rep.put("donnees",quest.getListeReponses().get(i).getDonnee_txt());
                values_rep.put("categorie",quest.getListeReponses().get(i).getCategorieAsString());
                db.insert("reponse",null, values_rep);
            }
        }




        // update static id
        ContentValues id_s = new ContentValues();
        id_s.put("ID_MAIN",MiniPollApp.id_Main);
        db.update("id_static", id_s, null, null);

    db.close();

    }


}