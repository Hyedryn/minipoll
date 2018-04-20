package be.lsinf1225.g16.mini_poll.model;

public class Sondage {

    protected final Utilisateur createur;

    protected Utilisateur participant;

    protected Question[] questions;

    protected Utilisateur[] participants;

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

    public Sondage(Utilisateur createur, Utilisateur[] participants, Question[] questions, Type t, Choix[] choix) {
        this.choix =choix;
        this.createur=createur;
        this.participants=participants;
        this.questions = questions;
        this.t = t;
        etat = Etat.ACTIF;
    }


}
