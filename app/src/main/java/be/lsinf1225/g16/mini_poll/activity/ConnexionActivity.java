package be.lsinf1225.g16.mini_poll.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.content.Intent;
import android.app.Activity;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.R;

public class ConnexionActivity extends AppCompatActivity {

    public static Activity login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        login = this;
    }

    public void register(View view)
    {
        Intent intent = new Intent(ConnexionActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View view)
    {
        Intent intent = new Intent(ConnexionActivity.this, MenuMainActivity.class);
        startActivity(intent);
        finish();
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
