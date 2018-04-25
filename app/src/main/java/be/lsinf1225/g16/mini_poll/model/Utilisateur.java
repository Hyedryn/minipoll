package be.lsinf1225.g16.mini_poll.model;

public class Utilisateur {
    /**
     * Identifiant unique de l'utilisateur courant. Correspond à _id dans la base de données.
     */
    private final int identifiant;
    /**
     * Nom (unique) de l'utilisateur courant. Correspond à u_nom dans la base de données.
     */
    private String nom;
    /**
     * Mot de passe de l'utilisateur courant. Correspond à u_password dans la base de données.
     */
    private String password;

    private String prenom;

    private String email;

    private String meilleur_ami;

    private Sondage[] sondages;

    private Utilisateur[] amis;

    private Utilisateur[] demandeAmis;

    //private File photo;


    private Utilisateur(int uId, String uPassword, String uNom, String uPrenom, String uEmail) {

        this.identifiant = uId;
        this.nom = uNom;
        this.password = uPassword;
        this.prenom = uPrenom;
        this.email = uEmail;
    }

    private Utilisateur(int uId, String uPassword, String uNom) {

        this.identifiant=uId;
        this.password=uPassword;
        this.nom=uNom;
    }

    //Methodes get //
    public int getIdentifiant() {
        return this.identifiant;
    }
    public String getPassword() {
        return this.password;
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public String getEmail() {
        return this.email;
    }

    //Methodes set//

    //pas de methode set pour identifiant parce que c'est un final int, ca sera un static augmente a chaque fois qu'on ajoute un utilisateur?
    public void setPassword(String password) {
        this.password=password;
    }
    public void setNom(String nom) {
        this.nom=nom;
    }
    public void setPrenom(String prenom) {
        this.prenom=prenom;
    }
    public void setEmail(String email){
        this.email=email;
    }

    //retourne un objet de type Utilisateur de l'ami dans la liste d'amis dont le nom correspond au nom passé en parametre
    public Utilisateur getAmi(String nom) {
        for(int i=0;i<this.amis.length;i++) {
            if(this.amis[i].getNom().equals(nom)==true) {
                System.out.println("Ami trouvé");
                System.out.println(this.amis[i].getNom().toString());
                return this.amis[i];
            }

        }
        return null; //si ami n'existe pas dans la liste des amis, retourne null, est ce qu'il faut retourner autre chose?? provoque null pointer exception
        //il faudrait utiliser un try catch ?
    }

    //retourne le sondage dont la question correspond au string passé en parametre

    public Sondage getSondage(final int id) {
        for(int i=0;i<this.sondages.length;i++) {
            if(this.sondages[i].getSondageId()==id) {
                return this.sondages[i];
            }
        }
        return null; //si pas trouvé dans la liste des sondages retourne null
    }

    //ajoute au tableau demandeAmis l'utilisateur dans la base de données dont le nom correspond au nom passé en parametre
    //NECESSITE INTERACTION AVEC BDD
    public void addDemandeAmi(String nom) {

    }
    //retire du tableau demandeAmis, l'utlisareur dont le nom correspond au nom passé en parametre
    public void removeDemandeAmi(String nom) {
        for(int i=0;i<this.demandeAmis.length;i++) {
            if(this.demandeAmis[i]!=null && this.demandeAmis[i].getNom().equals(nom)) {
                this.demandeAmis[i]=null;
                System.out.println("Demande supprimée");
                break;
            }
        }

    }

    //met la variable meilleurAmi à l'utilisateur (se trouvant deja dans la liste d'amis) dont le nom correspond au string passe en param
    public void setMeilleurAmi(String nom) {

        if((this.meilleur_ami!=null && this.meilleur_ami.equals(nom))==true) {
            System.out.println("Cet utilisateur est déjà votre meilleur ami");
        }else {
            for(int i=0;i<this.amis.length;i++) {
                if(this.amis[i]!=null && this.amis[i].getNom().equals(nom)==true) {
                    this.meilleur_ami=this.amis[i].getNom();
                    System.out.print("Meilleur ami changé à : ");
                    System.out.println(this.amis[i].getNom());
                    break;
                }
            }
        }
    }

    //a completer
    /*public boolean isAccepted(Utilisateur ut1, Utilisateur ut2) {

    }*/

    //utilisation des tableaux dynamiques ici?
    //j'ai changé type de retour de sondage à void
    //necessite interaction avec base de données pour chercher un sondage avec id correspondant

    /*public void addSondage (int id) {

    }*/


    public boolean checkId(String id) {
        int identifiant;
        try {
            identifiant=Integer.parseInt(id);
            if(this.identifiant==identifiant) {
                return true;
            }else {
                return false;
            }
        }catch(NumberFormatException e) {
            System.out.println("L'identifiant donné n'est pas valide");
            return false;
        }


    }

    public boolean checkMdp(String mdp) {
        if (this.getPassword().equals(mdp)==true) {
            return true;
        }else {
            return false;
        }
    }
    //a completer
    public void changeStatut(Utilisateur ut) {

    }


    public boolean sameMdp(Utilisateur ut) {
        if(this.getPassword().equals(ut.getPassword())==true) {
            return true;
        }else {
            return false;
        }
    }

    //NECESSITE INTERACTION AVEC BDD
    /*public boolean UtilisateurisAvailable(String nom) {

    }*/

    public String getID(Utilisateur ut) {
        String identifiant = Integer.toString(ut.getIdentifiant());
        return identifiant;
    }

    public String getMdp(Utilisateur ut) {
        return ut.getPassword();
    }
}