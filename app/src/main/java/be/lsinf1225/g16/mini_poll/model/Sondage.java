package be.lsinf1225.g16.mini_poll.model;


import java.util.ArrayList;

public class Sondage {

    protected final Utilisateur createur;

    protected Utilisateur participant;

    protected final int sondageId;

    protected Question[] questions;

    protected ArrayList<Utilisateur> participants;

    protected enum Etat {
        ACTIF,
        CLOTURE;
    }

    protected Choix[] choix;

    protected enum Type {
        QUESTIONNAIRE,
        AIDER_UN_AMi,
        SONDAGE_POUR_ACCORD;
    }

    Type t;
    Etat etat;

    public Sondage(Utilisateur createur, Utilisateur[] participants, int sondageId, Question[] questions, Type t, Choix[] choix) {
        this.choix =choix;
        this.createur=createur;
        this.participants=participants;
        this.sondageId=sondageId;
        this.questions = questions;
        this.t = t;
        etat = Etat.ACTIF;
    }

    public int getSondageId() {
        return this.sondageId;
    }

    public void setCreateur(Utilisateur x) {this.createur = x;}

    public Utilisateur getCreateur() {return this.createur;}

    public void setParticipant(Utilisateur name) {this.participant = name;}

    public Utilisateur getParicipant() {return this.participant;}

    public void setListeParticipants(Utilisateur[] liste)
    {
        for (int i = 0; i < liste.length(); i++){
            participants.add(liste[i]);
        }
    }

    public ArrayList<Utilisateur> getListeParticipants() {return this.participants;}

    public boolean getState() {return this.etat;}

    public void setQuestions(Question[] q) {this.questions = q;}

    public Question[] getQuestions() {return this.questions;}

    public void setChoix(Choix[] c) {this.choix = c;}

    public Choix[] getChoix() {return this.choix;}

    public String getType() {return this.t;}

    public boolean isCreatedBy(String name)
    {
        if (name.equals(createur.getIdentifiant())){
            return true;
        }
        return false;
    }

    public void addParticipants(Utilisateur ami) {this.participants.add(ami);}

    public void addQuestion(Question question)
    {
        for (int i = 0; i < this.questions.length(); i++){
            if (this.questions[i] == null){
                this.questions[i] = question;
            }
        }
    }
}