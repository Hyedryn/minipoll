package be.lsinf1225.g16.mini_poll.model;

import android.graphics.Bitmap;

public class Reponse {

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

    public Reponse(Categorie c, Format f, String d){
        this.c =c;
        this.f =f;
        this.donnee_txt =d;
    }

    public Reponse(Categorie c, Format f, Bitmap d){
        this.c =c;
        this.f =f;
        this.donnee_img =d;
    }

    public Reponse(String c, String f, String d){
        if(c.equals("bonne")){this.c=Categorie.BONNE;}
        else{this.c=Categorie.MAUVAISE;};
        if(f.equals("texte")){this.f=Format.TEXTE;}
        else{this.f=Format.IMAGE;};
        this.donnee_txt =d;
    }

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
