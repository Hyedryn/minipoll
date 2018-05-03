package be.lsinf1225.g16.mini_poll.model;

import java.util.Arrays;
import java.util.ArrayList;

public class Questionnaire extends Sondage {

    private Utilisateur[] classement;

    private int[] score;

    // builder

    public Questionnaire(Utilisateur createur, ArrayList<Utilisateur> participants, int sondageId, Question[] questions, Type t, Choix[] choix) {
        super(createur, participants,sondageId, questions, t, choix);

        this.classement = new Utilisateur[participants.size()];
        this.score = new int[participants.size()];
    }

    // les get

    public Utilisateur[] getClassement() {
        return this.classement;
    }

    public int[] getScore() {
        return score;
    }

    // les set

    public void setClassement(Utilisateur[] classement) {
        this.classement = classement;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    /**
     * calculateScore : calcul le score de l'utilisateur en argument
     * return : le score calculé
     */
    public int calculateScore(Utilisateur utilisateur){
        int score = 0;
        for (int i = 0; i < questions.length ; i++) {
            // Si la reponse du créateur = reponse de l'utilisateur :
            if (createur.getSondage(this.getSondageId()).choix[i].getReponse().equals(utilisateur.getSondage(this.getSondageId()).choix[i].getReponse())) {
                score++;
            }
        }
        return score;
    }

    /**
     * sortScore : trie les scores par ordre croissant
     * return : le tableau des scores triés
     */
    public int[] sortScore(){
        int[] ret =  this.score;
        Arrays.sort(ret);
        return ret;
    }

    /**
     * sortUtilisateurByScore : trie les utilisateurs selon leur score
     * return : tableau d'utilisateur
     */
    public Utilisateur[] sortUtilisateurByScore(Questionnaire questionnaire){
        Utilisateur[] copy = questionnaire.participants;
        Utilisateur[] ret = new Utilisateur[questionnaire.participants.length];
        int[] scoreSorted = questionnaire.sortScore();
        int score;
        for (int i = 0; i < questionnaire.participants.length; i++){
            score = scoreSorted[i];
            for (int j = 0; j < questionnaire.participants.length ; j++){
                if(score == questionnaire.score[j] && copy[j] != null){
                    ret[i] = copy[j];
                    copy[j] = null;
                }
            }
        }
        return ret;
    }

    /**
     * isAnswered : indique si le sondage en argument a été répondu par tout le monde
     * Si true : repondu par tout le monde
     * Si false : pas repondu par tout le monde
     */
    public boolean isAnswered(Sondage sondage){
        for (int i = 0; i < sondage.choix.length; i ++){
            // verification des reponses des utilisateurs
            if (sondage.choix[i] == null){ // si choix est null, il n'a pas répondu
                return false;
            }
        }
        return true;
    }

    /**
     * changeEtat : change l'etat du sondage passé en argument.
     * Si il est actif devient cloturé
     * Si il est cloturé devient actif
     */
    public void changeEtat(Sondage sondage){
        if(sondage.etat == Etat.ACTIF){
            sondage.etat = Etat.CLOTURE;
        }else{
            sondage.etat = Etat.ACTIF;
        }
    }

}
