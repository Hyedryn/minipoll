package be.lsinf1225.g16.mini_poll.model;

public class Question {

    private String Enonce;

    private int NombreReponses;

    private Reponse[] ListeReponses;

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

    public Question(String Enonce, int NombreReponses, Reponse[] ListeReponses){
        this.Enonce = Enonce;
        this.NombreReponses = NombreReponses;
        this.ListeReponses = ListeReponses;
    }

    public String getEnonce(){
        return this.Enonce;
    }

    public int getNbreReponses(){
        return this.NombreReponses;
    }

    public Reponse[] getListeReponses(){
        return this.ListeReponses;
    }

    public void setEnonce(String Enonce){
        this.Enonce = Enonce;
    }

    public void setNbreReponses(int NombreReponses){
        this.NombreReponses = NombreReponses;
    }

    public void setListeReponses(Reponse[] ListeReponses){
        this.ListeReponses = ListeReponses;
    }

}
