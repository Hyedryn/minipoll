package be.lsinf1225.g16.mini_poll.model;

public class Questionnaire extends Sondage {

    private Utilisateur[] classement;
    private int[] score;


    public Questionnaire(Utilisateur createur, Utilisateur[] participants, int sondageId, Question[] questions, Type t, Choix[] choix) {
        super(createur, participants,sondageId, questions, t, choix);

        classement = new Utilisateur[participants.length];
        score = new int[participants.length];
    }
}
