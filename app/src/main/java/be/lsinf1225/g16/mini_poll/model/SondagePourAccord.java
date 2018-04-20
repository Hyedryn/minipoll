package be.lsinf1225.g16.mini_poll.model;

public class SondagePourAccord extends Sondage {

    private Reponse[] classement;
    private int[] score;

    public SondagePourAccord(Utilisateur createur, Utilisateur[] participants, Question[] questions, Type t, Choix[] choix) {
        super(createur, participants, questions, t, choix);

        classement = new Reponse[questions[0].getNbreReponse()];
        score = new int[questions[0].getNbreReponse()];
    }
}
