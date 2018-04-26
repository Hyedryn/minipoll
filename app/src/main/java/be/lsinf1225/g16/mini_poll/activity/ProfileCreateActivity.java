package be.lsinf1225.g16.mini_poll.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

import static be.lsinf1225.g16.mini_poll.MiniPollApp.connectedUser;
import static be.lsinf1225.g16.mini_poll.MiniPollApp.utilisateurs;
import static be.lsinf1225.g16.mini_poll.activity.ConnexionActivity.login;
import static be.lsinf1225.g16.mini_poll.activity.RegisterActivity.register;

public class ProfileCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_create);
    }

    public void mainmenu(View view)
    {
        String nom = ((EditText) findViewById(R.id.cr_nom)).getText().toString();

        String prenom = ((EditText)findViewById(R.id.cr_prenom)).getText().toString();

        String email = ((EditText)findViewById(R.id.cr_email)).getText().toString();

        if(!nom.isEmpty()&&!prenom.isEmpty()&&!email.isEmpty()){

            if(email.contains("@")){

                //Step ok ouverture de la fenetre de creation du profile
                connectedUser.setEmail(email);
                connectedUser.setNom(nom);
                connectedUser.setPrenom(prenom);

                //ajout de l'utilisateur à la liste des utilisateurs et à la base de données
                utilisateurs.add(connectedUser);
                MiniPollApp.saveUser(connectedUser);


                Intent intent = new Intent(ProfileCreateActivity.this, MenuMainActivity.class);
                startActivity(intent);
                //fermeture des activités précédentes pour ne pas pouvoir retourner en arrière
                register.finish();
                login.finish();
                finish();

            }else{
                MiniPollApp.notifyShort(R.string.error_invalid_email);
            }

        }else{
            MiniPollApp.notifyShort(R.string.error_field_required);
        }


    }
}
