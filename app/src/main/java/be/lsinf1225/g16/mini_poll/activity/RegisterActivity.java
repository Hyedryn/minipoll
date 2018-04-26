package be.lsinf1225.g16.mini_poll.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

import static be.lsinf1225.g16.mini_poll.MiniPollApp.connectedUser;
import static be.lsinf1225.g16.mini_poll.MiniPollApp.utilisateurs;

public class RegisterActivity extends AppCompatActivity  implements TextView.OnEditorActionListener{

    public static Activity register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = this;

        // On indique qu'il faut appeler onEditorAction de cette classe lorsqu'une action (valider ici)
        // est faite depuis le clavier lorsqu'on est en train de remplir le mot de passe.
        EditText passwordConfirmEditText = (EditText) findViewById(R.id.confirm_password);
        passwordConfirmEditText.setOnEditorActionListener(this);
    }

    public void createprofile(View view)
    {
        String pseudo = ((EditText) findViewById(R.id.identifiant)).getText().toString();

        String mdp = ((EditText)findViewById(R.id.password)).getText().toString();

        String mdpconf = ((EditText)findViewById(R.id.confirm_password)).getText().toString();


        if(!(!pseudo.isEmpty()&&!mdp.isEmpty()&&!mdpconf.isEmpty())){
        MiniPollApp.notifyShort(R.string.error_field_required);
        return;
        }

        if(!mdp.equals(mdpconf)) {
            MiniPollApp.notifyShort(R.string.error_notmatching_password);
            return;
        }

        if(!MiniPollApp.isValidCharacter(pseudo+mdp+mdpconf)){
            MiniPollApp.notifyShort(R.string.error_invalid_char);
            return;
        }

        if(Utilisateur.utilisateurIsAvailable(pseudo)) {
            MiniPollApp.notifyShort(R.string.error_id_already_exist);
            return;
        }

            //Step ok ouverture de la fenetre de creation du profile
            MiniPollApp.connectedUser = new Utilisateur(pseudo, mdp);

            Intent intent = new Intent(RegisterActivity.this, ProfileCreateActivity.class);
            startActivity(intent);
    }



    /**
     * Récupère les actions faites depuis le clavier.
     * <p>
     * Récupère les actions faites depuis le clavier lors de l'édition du champ du mot de passe afin
     * de permettre de se connecter depuis le bouton "Terminer" du clavier. (Cela évite à
     * l'utilisateur de devoir fermer le clavier et de cliquer sur le bouton se connecter).
     */
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // L'attribut android:imeOptions="actionNext" est défini dans le fichier xml de layout
        // (activity_login.xml), L'actionId attendue est donc IME_ACTION_NEXT.
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            createprofile(v);
            return true;
        }
        return false;
    }
}
