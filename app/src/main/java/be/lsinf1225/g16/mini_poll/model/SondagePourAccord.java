package be.lsinf1225.g16.mini_poll.model;

import java.util.ArrayList;

public class SondagePourAccord extends Sondage {

    private Reponse[] classement;
    private int[] score;

    public SondagePourAccord(Utilisateur createur, ArrayList<Participant> participants, int sondageId, ArrayList<Question> questions, Type t) {
        super(createur, participants, sondageId, questions, t);

    //    classement = new Reponse[questions[0].getNbreReponse()];
    //    score = new int[questions[0].getNbreReponse()];
    }
}
