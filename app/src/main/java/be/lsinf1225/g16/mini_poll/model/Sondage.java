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

    public Sondage(Utilisateur createur, ArrayList<Utilisateur> participants, int sondageId, Question[] questions, Type t, Choix[] choix) {
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

}