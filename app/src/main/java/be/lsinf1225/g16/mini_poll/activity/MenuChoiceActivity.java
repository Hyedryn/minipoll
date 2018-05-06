package be.lsinf1225.g16.mini_poll.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Sondage;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class MenuChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_choice);
        System.out.println("yo!!");
        if(MiniPollApp.connectedUser.getSondages()!=null){
            //added LInearLayout
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.menu_choice_linear_layout);
        for(Sondage s : MiniPollApp.connectedUser.getSondages()) {
            //si utilisateur existe l'ajouter
            System.out.println("Sondage non vide!!");
            if(s.getType().equals(Sondage.Type.AIDER_UN_AMI)) {

                if(s.getCreateur().equals(MiniPollApp.connectedUser)){
                    Button b = new Button(this);
                    b.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 80.0f));
                    String id;
                    if(s.getListeParticipants().get(0).getParticipant().equals(MiniPollApp.connectedUser)){
                        id=s.getListeParticipants().get(1).getParticipant().getIdentifiant();
                    }else{
                        id=s.getListeParticipants().get(0).getParticipant().getIdentifiant();
                    }
                    b.setText("Demande d'aide à "+id);
                    b.setBackgroundColor(getResources().getColor(R.color.Button1));
                    linearLayout.addView(b, linearLayout.indexOfChild(findViewById(R.id.menu_choice_mes_demandes_aides))+1);
                }else if(s.getState().equals(Sondage.Etat.ACTIF)){
                    Button b = new Button(this);
                    b.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 80.0f));
                    b.setText(s.getCreateur().getIdentifiant()+" a besoin de ton aide!");
                    b.setBackgroundColor(getResources().getColor(R.color.Button1));
                    linearLayout.addView(b, linearLayout.indexOfChild(findViewById(R.id.menu_choice_demandes_aides_ouvertes))+1);
                }else if(s.getState().equals(Sondage.Etat.CLOTURE)){
                    Button b = new Button(this);
                    b.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 80.0f));
                    b.setText(s.getCreateur().getIdentifiant()+" a besoin de ton aide!");
                    b.setBackgroundColor(getResources().getColor(R.color.Button1));
                    linearLayout.addView(b, linearLayout.indexOfChild(findViewById(R.id.menu_choice__demandes_aides_clotures))+1);
                }

            }
        }
        }
    }



}
