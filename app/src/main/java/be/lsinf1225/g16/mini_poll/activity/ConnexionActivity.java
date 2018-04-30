package be.lsinf1225.g16.mini_poll.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.content.Intent;
import android.app.Activity;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.MySQLiteHelper;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;


public class ConnexionActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    public static Activity login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        login = this;

        // On indique qu'il faut appeler onEditorAction de cette classe lorsqu'une action (valider ici)
        // est faite depuis le clavier lorsqu'on est en train de remplir le mot de passe.
        EditText passwordEditText = (EditText) findViewById(R.id.login_pwd);
        passwordEditText.setOnEditorActionListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // On efface le mot de passe qui était écrit quand on se déconnecte.
        EditText passwordEditText = (EditText) findViewById(R.id.login_pwd);
        passwordEditText.setText("");
    }


    public void register(View view)
    {
        Intent intent = new Intent(ConnexionActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View view)
    {
        AutoCompleteTextView userEditText = (AutoCompleteTextView) findViewById(R.id.login_id);
        EditText passwordEditText = (EditText) findViewById(R.id.login_pwd);
        String password = passwordEditText.getText().toString();
        String id = userEditText.getText().toString();

        for(Utilisateur user : MiniPollApp.utilisateurs) {

            if(user.getIdentifiant().equals(id)) {

                if(!user.checkMdp(password)) {
                    MiniPollApp.notifyShort(R.string.error_invalid_password);
                    passwordEditText.setText("");
                    return;
                }

                MiniPollApp.connectedUser = user;
                MiniPollApp.loadConnectedUser();

                Intent intent = new Intent(ConnexionActivity.this, MenuMainActivity.class);
                startActivity(intent);
                finish();
                return;

            }
        }

        MiniPollApp.notifyShort(R.string.error_invalid_id);

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
            login(v);
            return true;
        }
        return false;
    }


}
