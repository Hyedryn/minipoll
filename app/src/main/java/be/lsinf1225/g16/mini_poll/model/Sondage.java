package be.lsinf1225.g16.mini_poll.model;

import java.util.ArrayList;

public class Sondage {

    protected final Utilisateur createur;

    protected final int sondageId;

    protected ArrayList<Question> questions;

    protected ArrayList<Participant> participants;

    public enum Etat {
        ACTIF,
        CLOTURE;
    }


    public enum Type {
        QUESTIONNAIRE,
        AIDER_UN_AMI,
        SONDAGE_POUR_ACCORD;
    }

    Type t;
    Etat etat;

    public Sondage(Utilisateur createur, ArrayList<Participant> participants, int sondageId, ArrayList<Question> questions, Type t) {
        this.createur=createur;
        this.participants=participants;
        this.sondageId=sondageId;
        this.questions = questions;
        this.t = t;
        etat = Etat.ACTIF;
    }
    public Sondage(int sondageId,Utilisateur createur,String etat){
        this.sondageId=sondageId;
        this.createur=createur;
        if(etat.equalsIgnoreCase("ACTIF")||etat.equalsIgnoreCase("ouvert")){this.etat=Etat.ACTIF;}
        else{this.etat=Etat.CLOTURE;};

    }

    public int getSondageId() {
        return this.sondageId;
    }

    public Utilisateur getCreateur() {return this.createur;}


    public void setListeParticipants(ArrayList<Participant> participants)
    {
        this.participants=participants;
    }

    public ArrayList<Participant> getListeParticipants() {return this.participants;}

    public Participant getParticipant(Utilisateur u) {
        for(Participant p : this.participants) {
            if(p.getParticipant().equals(u)) {
                return p;
            }
        }
        return null;
    }

    public Etat getState() {return this.etat;}

    public void setQuestions(ArrayList<Question> q) {this.questions = q;}

    public ArrayList<Question> getQuestions() {return this.questions;}


    public void setType(String type){
        if(type.equals("sondage")){this.t=Type.SONDAGE_POUR_ACCORD;}
        else if(type.equals("questionnaire")){this.t=Type.QUESTIONNAIRE;}
        else{this.t=Type.AIDER_UN_AMI;}
    }

    public Type getType() {return this.t;}

    public void setEtat(Etat e){
        this.etat = e;
    }

    public boolean isCreatedBy(String name)
    {
        if (name.equals(createur.getIdentifiant())){
            return true;
        }
        return false;
    }

    public void addParticipants(Participant ami) {
        if(this.participants==null)
            this.participants= new ArrayList<Participant>();

        this.participants.add(ami);
    }

    public void addQuestion(Question question)
    {
        if(this.questions==null)
            this.questions= new ArrayList<Question>();

        this.questions.add(question);
    }
}