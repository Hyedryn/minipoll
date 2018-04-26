package be.lsinf1225.g16.mini_poll.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        ((TextView)findViewById(R.id.pr_id)).setText("ID:  "+MiniPollApp.connectedUser.getIdentifiant());
        ((TextView)findViewById(R.id.pr_nom)).setText("Nom:  "+MiniPollApp.connectedUser.getNom());
        ((TextView)findViewById(R.id.pr_prenom)).setText("Prénom:  "+MiniPollApp.connectedUser.getPrenom());
        ((TextView)findViewById(R.id.pr_email)).setText("Email:  "+MiniPollApp.connectedUser.getEmail());

        if(MiniPollApp.connectedUser.getPhoto()!=null)
            ((ImageView) findViewById(R.id.pr_imgView)).setImageBitmap(MiniPollApp.connectedUser.getPhoto());

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}
