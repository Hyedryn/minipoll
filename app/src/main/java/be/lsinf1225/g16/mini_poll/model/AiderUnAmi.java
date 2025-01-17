package be.lsinf1225.g16.mini_poll.model;

import java.util.ArrayList;

public class AiderUnAmi extends Sondage {

    private Reponse resultat;

    public AiderUnAmi(Utilisateur createur, ArrayList<Participant> participants, int sondageId, ArrayList<Question> questions, Type t) {
        super(createur, participants, sondageId, questions, t);
    }

    //get et set hérités de sondage

    public Reponse getResult() {
        return this.resultat;
    }

    public void setResult(Reponse reponse) {
        this.resultat = reponse;
    }

//pour determiner si le participant a deja repondu a la question on regarde la valeur de resultat, si null: pas repondu

    public boolean isAnswered() {
        if (resultat != null) {
            return true;
        } else {
            return false;
        }
    }

}