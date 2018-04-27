package be.lsinf1225.g16.mini_poll.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class FriendsAddActivity extends AppCompatActivity {

    private static ArrayList<Utilisateur> notfriends = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_add);

        for(Utilisateur u : MiniPollApp.utilisateurs){
            if(MiniPollApp.connectedUser.getAmi(u.getIdentifiant())==null&&!u.equals(MiniPollApp.connectedUser)){
                notfriends.add(u);
            }
        }

        System.out.println("user size"+notfriends.size());
        if(notfriends==null||notfriends.size()<1){
            displayUser(null);
        }else {
            displayUser(notfriends.get(0));
        }
    }

    private void displayUser(Utilisateur u){
        if(u==null){
            ((TextView)findViewById(R.id.add_name_inf)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.add_surname_inf)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.add_ajouter_txt)).setText(R.string.error_no_available_friend);
            ((TextView)findViewById(R.id.add_ajouter_txt)).setTextSize(12);
            return;
        }

        MiniPollApp.loadUser(u);
        ((TextView)findViewById(R.id.add_name_inf)).setText(u.getNom());
        ((TextView)findViewById(R.id.add_surname_inf)).setText(u.getPrenom());

        if(u.getPhoto()!=null&&u.getPhoto().getConfig()!=null)
            ((ImageView) findViewById(R.id.add_profil_img)).setImageBitmap(u.getPhoto());

    }
}
