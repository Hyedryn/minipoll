package be.lsinf1225.g16.mini_poll.model;

import android.graphics.Bitmap;

public class Reponse {

    protected int reponseId;

    protected enum Format {
        IMAGE,
        TEXTE;
    }

    protected enum Categorie {
        BONNE,
        MAUVAISE;
    }

    private Format f;

    private Categorie c;

    private String donnee_txt;

    private Bitmap donnee_img;

    public Reponse(int reponseId, Categorie c, Format f, String d){
        this.reponseId=reponseId;
        this.c =c;
        this.f =f;
        this.donnee_txt =d;
    }

    public Reponse(int reponseId,Categorie c, Format f, Bitmap d){
        this.reponseId=reponseId;
        this.c =c;
        this.f =f;
        this.donnee_img =d;
    }

    public Reponse(int reponseId,String c, String f, String d){
        this.reponseId=reponseId;
        if("bonne".equals(c)){this.c=Categorie.BONNE;}
        else{this.c=Categorie.MAUVAISE;};
        if("texte".equals(f)){this.f=Format.TEXTE;}
        else{this.f=Format.IMAGE;};
        this.donnee_txt =d;
    }

    public int getReponseId() {return this.reponseId;}

    public String getDonnee_txt(){
        return this.donnee_txt;
    }

    public void setReponseId(int reponseId){this.reponseId=reponseId;}

    public void setFormat(Format f) {
        this.f = f;
    }

    public void setDonnee(Bitmap donnee_img) {
        this.donnee_img = donnee_img;
    }

    public void setDonnee(String donnee_txt) {
        this.donnee_txt = donnee_txt;
    }

    public void setCategorie(Categorie c) {
        this.c = c;
    }
}
