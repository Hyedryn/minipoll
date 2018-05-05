package be.lsinf1225.g16.mini_poll.model;

import java.util.ArrayList;

import static be.lsinf1225.g16.mini_poll.MiniPollApp.utilisateurs;

public class Participant {

    protected int sondageID=0;
    private Utilisateur participant;
    private ArrayList<Choix> choix;


    protected enum Status {
        A_REPONDU,
        EN_ATTENTE;
    }

    private Status s;

    private Participant(Utilisateur participant, Choix c, Status s){
        this.participant=participant;
        this.choix =new ArrayList<Choix>();
        this.choix.add(c);
        this.s=s;
    }

    public Participant(Utilisateur participant, int sondageId, String status){
        this.participant=participant;
        this.sondageID=sondageId;

        if(status.equals("a repondu"))
            this.s = Status.A_REPONDU;
        else
            this.s = Status.EN_ATTENTE;

    }

    public Participant(String id, int sondageId, String status){

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

    public ArrayList<Choix> getChoix() {
        return this.choix;
    }

    public Status getStatus() {
        return this.s;
    }

    //methodes set

    public void setParticipant(Utilisateur participant) {
        this.participant=participant;
    }

    public void setChoix(ArrayList<Choix> choix) {
        this.choix=choix;
    }

    public int getSondageID(){
        return sondageID;
    }

    //methodes add
    public void addChoix(Choix c){
        if(this.choix==null)
            this.choix= new ArrayList<Choix>();

        this.choix.add(c);

    }

}