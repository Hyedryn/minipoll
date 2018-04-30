package be.lsinf1225.g16.mini_poll.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class MenuMainActivity extends AppCompatActivity {

    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        if(MiniPollApp.connectedUser.getListDemandeAmi()!=null){
        for(Utilisateur demandeami : MiniPollApp.connectedUser.getListDemandeAmi()) {
            friendRequest(demandeami);
            alertDialog.show();

        }
        }

    }

    private void friendRequest(final Utilisateur u){
        alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Nouvelle demande d'Ami!!");

        alertDialog.setMessage(u.getIdentifiant()+" vous a demandé en ami!");

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Refuser", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                MiniPollApp.connectedUser.removeDemandeAmi(u);
                return;
            } });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Ignorer", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                return;
            }});

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ajouter", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                MiniPollApp.connectedUser.removeDemandeAmi(u);
                MiniPollApp.connectedUser.addAmi(u);
                u.addAmi(MiniPollApp.connectedUser);
                return;
            }});
    }

    public void friends(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, FriendsActivity.class);
        startActivity(intent);
    }

    public void profileedit(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, ProfileEditActivity.class);
        startActivity(intent);
    }

    public void profile(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void menu_choice(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, MenuChoiceActivity.class);
        startActivity(intent);
    }

    public void menu_agreement(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, MenuAgreementActivity.class);
        startActivity(intent);
    }

    public void menu_question(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, MenuQuestionActivity.class);
        startActivity(intent);
    }

    public void menu_survey_creation(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, MenuSurveyCreationActivity.class);
        startActivity(intent);
    }
}
