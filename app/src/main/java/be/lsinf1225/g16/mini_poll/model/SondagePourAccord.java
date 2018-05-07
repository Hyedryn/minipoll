package be.lsinf1225.g16.mini_poll.model;

import java.util.ArrayList;

public class SondagePourAccord extends Sondage {

    private Reponse[] classement;
    private int[] score;
    private Choix[] tableauChoix = makeTableauChoix(); // je suis pas sure si c'est une variable d'instance du coup :/
    private int NombreChoixMax; //c'est N dans le cahier de charge


    public SondagePourAccord(Utilisateur createur, ArrayList<Participant> participants, int sondageId, ArrayList<Question> questions, Type t) {
        super(createur, participants, sondageId, questions, t);

        //    classement = new Reponse[questions[0].getNbreReponse()];
        //    score = new int[questions[0].getNbreReponse()];
    }

    public void setClassement(Reponse[] reponses) {this.classement = reponses;}

    public Reponse[] getClassement() {return this.classement;}

    public void setScore(int[] score) {this.score = score;}

    public int[] getScore() {return this.score;}

    public void setNbreChoixMax(int n) {this.NombreChoixMax = n;}

    public int getNbreChoixMax() {return this.NombreChoixMax;}




    public int calculatePoidsTotal(Reponse reponse)
    {
        Choix[] choix = this.tableauChoix;
        int poids = 0;
        for (int i = 0; i < choix.length; i++){
            if (choix[i].getReponse() == reponse){
                poids = poids + choix[i].getPoids();
            }
        }
        return poids;
    }

    /**
     *Pour decaler tous les elemnts du tableau a partir d'un certain index (tableau de reponse)
     */
    public Reponse[] decaleReponse(Reponse[] tab1, int index)
    {
        Reponse[] tab2 = new Reponse[tab1.length];
        for (int i = index; i < tab1.length; i++){
            tab2[i + 1] = tab1[i];
        }
        return tab2;
    }

    /**
     * Pour decaler tous les elements du tableau a partir d'un certain index (tableau de int)
     * ps: y a deux fct decale (une pour chaque type) pcq ça marche pas si je mets Object :/
     */
    public int[] decaleInt(int[] tab1, int index) {
        int[] tab2 = new int[tab1.length];
        for (int i = index; i < tab1.length; i++) {
            tab2[i + 1] = tab1[i];
        }
        return tab2;
    }

    public void sortReponseByPoids()
    {
        Choix[] choix = this.tableauChoix;
        classement[0] = choix[0].getReponse();
        score[0] = choix[0].getPoids();
        for (int i = 0; i < choix.length; i++){
            for (int j = 0; j < 6; j++){
                Reponse reponse = choix[i].getReponse();
                int poids = calculatePoidsTotal(reponse);
                if (!reponse.equals(classement[j])){
                    if (poids > calculatePoidsTotal(classement[j])){
                        classement = decaleReponse(classement, j);
                        score = decaleInt(score, j);
                        classement[j] = reponse;
                        score[j] = poids;
                    }
                    classement[j] = reponse;
                    score[j] = poids;
                }
            }
        }
    }

    public int checkNumberOfPoidsMax()
    {
        int count = 1;
        int poids = score[0];
        for (int i = 1; i < score.length; i ++){
            if (score[i] == poids){
                count++;
            }
        }
        return count;
    }

    public Reponse getResult()
    {
        if (checkNumberOfPoidsMax() > 1){
            return null;//chooseReponse(2); // --> !! faudra changer!! je sais pas quoi mettre :/
        }
        return classement[0];
    }

    public Reponse[] moreThanOne(){
        if (checkNumberOfPoidsMax() > 1){
            return classement;
        }
        return null;
    }

    /**
     * choisir la reponse numero n
     */
    public Reponse chooseReponse(int n) {return classement[n];}

    /**
     * si le nombre de choix total choisis par les participants est different du nombre de choix a choisir
     */
    public boolean isAnswered()
    {
        int p = super.getListeParticipants().size(); //nombre de participants
        Choix[] tab = this.tableauChoix;
        int answers = 0; //nombre de reponses selectionnees
        for (int j = 0; j < tab.length; j++){
            if(tab[j] != null){
                answers++;
            }
        }
        if (answers != (p * this.NombreChoixMax)){
            return false;
        }
        return true;
    }


    public void changeEtat(Sondage sondage){
        if(sondage.etat == Etat.ACTIF){
            sondage.etat = Etat.CLOTURE;
        }else{
            sondage.etat = Etat.ACTIF;
        }
    }

    /**
     * compte le nombre total de reponses du sondage
     */
    public int countReponses(ArrayList<Question> tab)
    {
        int count = 0;
        for (int i = 0; i < tab.size(); i++){
            count = count + tab.get(i).getNbreReponses();
        }
        return count;
    }

     /**
      * Pour rassembler tous les tableaux en un seul
      */
    public Choix[] makeTableauChoix()
    {
        ArrayList<Participant> participants = super.getListeParticipants();
        int tabLength = participants.size() * countReponses(super.getQuestions());
        Choix[] choix = new Choix[tabLength];
        int count = 0;
        for (int i = 0; i < participants.size(); i++){
            int size = participants.get(i).getChoix().size();
            ArrayList<Choix> c = participants.get(i).getChoix();
            for (int j = 0; j < size; j++){
                choix[count] = c.get(j);
                count++;
            }
        }
        return choix;
    }
}
