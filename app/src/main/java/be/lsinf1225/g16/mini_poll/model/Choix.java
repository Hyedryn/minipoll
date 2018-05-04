package be.lsinf1225.g16.mini_poll.model;

import static be.lsinf1225.g16.mini_poll.MiniPollApp.utilisateurs;

public class Choix {
    protected int sondageID=0;
    private Utilisateur participant;
    private Reponse reponse;
    private int poids;


    protected enum Status {
        A_REPONDU,
        EN_ATTENTE;
    }

    private Status s;

    private Choix(Utilisateur participant, Reponse reponse, int poids){
        this.participant=participant;
        this.reponse=reponse;
        this.poids=poids;
    }

    public Choix(Utilisateur participant, int sondageId, String status){
        this.participant=participant;
        this.sondageID=sondageId;

        if(status.equals("a repondu"))
            this.s = Status.A_REPONDU;
        else
            this.s = Status.EN_ATTENTE;

    }

    public Choix(String id, int sondageId, String status){

        for(Utilisateur user : utilisateurs) {
            if(user.getIdentifiant().equals(id)){
                this.participant=user;
                this.sondageID=sondageId;

                if(status.equals("a repondu"))
                    this.s = Status.A_REPONDU;
                else
                    this.s = Status.EN_ATTENTE;
            }
        }

    }

    //methodes get

    public Utilisateur getParticipant() {
        return this.participant;
    }

    public Reponse getReponse() {
        return this.reponse;
    }

    public int getPoids() {
        return this.poids;
    }

    //methodes set

    public void setParticipant(Utilisateur participant) {
        this.participant=participant;
    }

    public void setPoids(int poids) {
        this.poids=poids;
    }

    public int getSondageID(){
        return sondageID;
    }

    //autres methodes
    public void setChoix(Utilisateur participant, Reponse reponse, int poids){
        this.participant=participant;
        this.reponse=reponse;
        this.poids=poids;
    }
    public Choix getChoix(){
        return this;
    }
}