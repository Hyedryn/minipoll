package be.lsinf1225.g16.mini_poll.model;

public class Questionnaire extends Sondage {

    private Utilisateur[] classement;

    private int[] score;

    public Questionnaire(Utilisateur createur, Utilisateur[] participants, int sondageId, Question[] questions, Type t, Choix[] choix) {
        super(createur, participants,sondageId, questions, t, choix);

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
return 0;
    }

    public int[] sortScore(){
       return null;
    }

    public Utilisateur[] sortUtilisateurByScore(Sondage sondage){
return null;
    }

    public boolean isAnswered(Sondage sondage){
return false;
    }

    public void changeEtat(Sondage sondage){

    }

}
