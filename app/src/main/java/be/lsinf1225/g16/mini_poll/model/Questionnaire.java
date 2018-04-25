package be.lsinf1225.g16.mini_poll.model;

public class Questionnaire extends Sondage {

    private Utilisateur[] classement;

    private int[] score;

    public Questionnaire(Utilisateur createur, Utilisateur[] participants, Question[] questions, Type t, Choix[] choix) {
        super(createur, participants, questions, t, choix);

        this.classement = new Utilisateur[participants.length];
        this.score = new int[participants.length];
    }

    public Utilisateur[] getClassement() {
        return this.classement;
    }

    public int[] getScore() {
        return score;
    }

    public void setClassement(Utilisateur[] classement) {
        this.classement = classement;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public int calculateScore(Utilisateur utilisateur){

    }

    public int[] sortScore(){

    }

    public Utilisateur[] sortUtilisateurByScore(Sondage sondage){

    }

    public boolean isAnswered(Sondage sondage){

    }

    public void changeEtat(Sondage sondage){

    }

}
