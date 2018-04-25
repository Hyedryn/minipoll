package be.lsinf1225.g16.mini_poll.model;

public class Choix {
    private Utilisateur participant;
    private Reponse reponse;
    private int poids;

    private Choix(Utilisateur participant, Reponse reponse, int poids){
        this.participant=participant;
        this.reponse=reponse;
        this.poids=poids;
    }

    //methodes get

    public Utilisateur getPatricipant() {
        return this.participant;
    }

    public Reponse getReponse() {
        return this.reponse;
    }

    public int getPoids() {
        return this.poids;
    }

    //methodes set

    public void setPatricipant(Utilisateur participant) {
        this.participant=participant;
    }

    public void setPoids(int poids) {
        this.poids=poids;
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