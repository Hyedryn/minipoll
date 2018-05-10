package be.lsinf1225.g16.mini_poll.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Sondage;

public class MenuQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_question);

        if(MiniPollApp.connectedUser.getSondages()!=null){
            //added LinearLayout
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.menu_question_linear_layout);
            for(final Sondage s : MiniPollApp.connectedUser.getSondages()) {
                //si utilisateur existe l'ajouter

                if(s.getType().equals(Sondage.Type.QUESTIONNAIRE)) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 80.0f);
                    params.setMargins(1,1,1,1);
                    if(s.getCreateur().equals(MiniPollApp.connectedUser)){
                        Button b = new Button(this);
                        b.setLayoutParams(params);
                        b.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(MenuQuestionActivity.this, ReplyQuestionActivity.class);
                                intent.putExtra("sondageID",s.getSondageId());
                                startActivity(intent);
                            }
                        });
                        b.setText("Questionnaire "+s.getSondageId());
                        b.setBackgroundColor(getResources().getColor(R.color.Button1));
                        linearLayout.addView(b, linearLayout.indexOfChild(findViewById(R.id.menu_question_mes_questions))+1);
                    }else if(s.getState().equals(Sondage.Etat.ACTIF)){
                        Button b = new Button(this);
                        b.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(MenuQuestionActivity.this, ReplyQuestionActivity.class);
                                intent.putExtra("sondageID",s.getSondageId());
                                startActivity(intent);
                            }
                        });
                        b.setLayoutParams(params);
                        b.setText("Questionnaire de "+s.getCreateur().getIdentifiant());
                        b.setBackgroundColor(getResources().getColor(R.color.Button1));
                        linearLayout.addView(b, linearLayout.indexOfChild(findViewById(R.id.menu_question_ouvertes))+1);
                    }else if(s.getState().equals(Sondage.Etat.CLOTURE)){
                        Button b = new Button(this);
                        b.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(MenuQuestionActivity.this, ReplyQuestionActivity.class);
                                intent.putExtra("sondageID",s.getSondageId());
                                startActivity(intent);
                            }
                        });
                        b.setLayoutParams(params);
                        b.setText("Questionnaire de "+s.getCreateur().getIdentifiant());
                        b.setBackgroundColor(getResources().getColor(R.color.Button1));
                        linearLayout.addView(b, linearLayout.indexOfChild(findViewById(R.id.menu_question_questions_clotures))+1);
                    }

                }
            }
        }
    }
}
