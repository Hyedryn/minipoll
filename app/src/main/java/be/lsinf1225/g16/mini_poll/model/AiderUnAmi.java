package be.lsinf1225.g16.mini_poll.model;

public class AiderUnAmi extends Sondage {

    private Reponse resultat;

    public AiderUnAmi(Utilisateur createur, Utilisateur[] participants, Question[] questions, Type t, Choix[] choix) {
        super(createur, participants, questions, t, choix);
    }
}
