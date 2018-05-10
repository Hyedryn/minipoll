package be.lsinf1225.g16.mini_poll.activity.replyFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.ReplyChoiceActivity;
import be.lsinf1225.g16.mini_poll.model.AiderUnAmi;
import be.lsinf1225.g16.mini_poll.model.Question;
import be.lsinf1225.g16.mini_poll.model.Reponse;
import be.lsinf1225.g16.mini_poll.model.Sondage;

public class ReplyChoiceFillAnswer extends Fragment {

    private Sondage sondage = ReplyChoiceActivity.sondage;

    private ArrayList<Question> question = sondage.getQuestions();

    private ArrayList<Reponse> ListeReponses = (question.get(0)).getListeReponses();

    private TextView titre;
    private TextView questionText;
    private TextView reponse1;
    private TextView reponse2;
    private CheckBox checkBox1;
    private CheckBox checkBox2;

    private AiderUnAmi aiderUnAmi = (AiderUnAmi) sondage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.reply_choice_fill_answer, container, false);

     //   titre = (TextView) getActivity().findViewById(R.id.reply_choice_title);
      //  questionText = (TextView) getActivity().findViewById(R.id.reply_choice_question);
       // titre.setText("Aider " + sondage.getCreateur().getPrenom() + " à faire un choix");
      //  questionText.setText(question.get(0).getEnonce());
      //  reponse1 = (TextView) getActivity().findViewById(R.id.reply_choice_reponse1);
      //  reponse2 = (TextView) getActivity().findViewById(R.id.reply_choice_reponse2);
     //   reponse1.setText(ListeReponses.get(0).getDonnee_txt());
      //  reponse2.setText(ListeReponses.get(0).getDonnee_txt());

        return rootView;
    }

    /*
    public void Answer(){
        if(checkBox1.isChecked()){
            aiderUnAmi.setResult(ListeReponses.get(0));
        }
        else if(checkBox2.isChecked()){
            aiderUnAmi.setResult(ListeReponses.get(1));
        }
        else{
            MiniPollApp.notifyShort(R.string.error_field_required);
        }
    }
    */
}