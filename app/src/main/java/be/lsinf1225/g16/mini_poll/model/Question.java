package be.lsinf1225.g16.mini_poll.model;

import java.util.ArrayList;

public class Question {
    private int questionId;

    private String Enonce;

    private int NombreReponses;

    private ArrayList<Reponse> ListeReponses;

    // builders

    public Question(){
        this.Enonce = null;
        this.NombreReponses = 0;
        this.ListeReponses = null;
    }

    public Question(String Enonce){
        this.Enonce = Enonce;
        this.NombreReponses = 0;
        this.ListeReponses = null;
    }

    public Question(String Enonce, int NombreReponses, ArrayList<Reponse> ListeReponses, int questionId){
        this.Enonce = Enonce;
        this.NombreReponses = NombreReponses;
        this.ListeReponses = ListeReponses;
        this.questionId=questionId;
    }

    // les get

    public String getEnonce(){
        return this.Enonce;
    }

    public int getNbreReponses(){
        return this.NombreReponses;
    }

    public ArrayList<Reponse> getListeReponses(){
        return this.ListeReponses;
    }

    public int getQuestionId(){return this.questionId;}

    // les set

    public void setEnonce(String Enonce){
        this.Enonce = Enonce;
    }

    public void setNbreReponses(int NombreReponses){
        this.NombreReponses = NombreReponses;
    }

    public void setListeReponses(ArrayList<Reponse> ListeReponses){
        this.ListeReponses = ListeReponses;
    }

    public void setQuestionId(int questionId){this.questionId=questionId;}

    public void addReponse(Reponse r){
        if(this.ListeReponses==null){
            this.ListeReponses=new ArrayList<Reponse>();
            this.ListeReponses.add(r);
        }else
        this.ListeReponses.add(r);
    }

}

