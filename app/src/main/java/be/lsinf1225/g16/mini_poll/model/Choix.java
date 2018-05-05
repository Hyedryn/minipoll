package be.lsinf1225.g16.mini_poll.model;

import static be.lsinf1225.g16.mini_poll.MiniPollApp.utilisateurs;

public class Choix {
    private Reponse reponse;
    private int poids;


    protected enum Status {
        A_REPONDU,
        EN_ATTENTE;
    }

    private Status s;

    private Choix(Reponse reponse, int poids){
        this.reponse=reponse;
        this.poids=poids;
    }

    public Choix(String status){
        if(status.equals("a repondu"))
            this.s = Status.A_REPONDU;
        else
            this.s = Status.EN_ATTENTE;

    }


    //methodes get


    public Reponse getReponse() {
        return this.reponse;
    }

    public int getPoids() {
        return this.poids;
    }

    //methodes set


    public void setPoids(int poids) {
        this.poids=poids;
    }


    //autres methodes
    public void setChoix(Reponse reponse, int poids){
        this.reponse=reponse;
        this.poids=poids;
    }
    public Choix getChoix(){
        return this;
    }
}