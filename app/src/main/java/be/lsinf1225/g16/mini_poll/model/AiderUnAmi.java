package be.lsinf1225.g16.mini_poll.model;

public class AiderUnAmi extends Sondage {

    private Reponse resultat;

    public AiderUnAmi(Utilisateur createur, Utilisateur[] participants, int sondageId, Question[] questions, Type t, Choix[] choix) {
        super(createur, participants, sondageId, questions, t, choix);
    }

    public Reponse getChoix(Choix x) {
        return x.getReponse();
    }

    public void setResult(Reponse reponse) {
        this.resultat = reponse;
    }

    public Reponse getResult() {
        return this.resultat;
    }

//pour determiner si le participant a deja repondu a la question on regarde la valeur de resultat, si null: pas repondu

    public boolean isAnswered() {
        if (resultat != null) {
            return true;
        } else {
            return false;
        }
    }

    public void changeEtat(Etat etat) {
        this.etat = etat;
    }
}