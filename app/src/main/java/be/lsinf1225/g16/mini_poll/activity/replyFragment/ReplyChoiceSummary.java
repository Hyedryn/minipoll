package be.lsinf1225.g16.mini_poll.activity.replyFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.ReplyChoiceActivity;
import be.lsinf1225.g16.mini_poll.model.AiderUnAmi;
import be.lsinf1225.g16.mini_poll.model.Question;
import be.lsinf1225.g16.mini_poll.model.Reponse;
import be.lsinf1225.g16.mini_poll.model.Sondage;

import static be.lsinf1225.g16.mini_poll.activity.ReplyChoiceActivity.sondage;

public class ReplyChoiceSummary extends Fragment {

    private Sondage sondage = ReplyChoiceActivity.sondage;

    private ArrayList<Question> question = sondage.getQuestions();

    private ArrayList<Reponse> ListeReponses = (question.get(0)).getListeReponses();

    private AiderUnAmi aiderUnAmi = (AiderUnAmi) sondage;

    private TextView titre;
    private TextView questionText;
    private TextView answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.reply_choice_summary, container, false);

        titre = (TextView) getActivity().findViewById(R.id.reply_choice_summary_title);
        questionText = (TextView) getActivity().findViewById(R.id.reply_choice_summary_question);
        answer = (TextView) getActivity().findViewById(R.id.reply_choice_summary_answer);

        titre.setText("Aider " + sondage.getCreateur().getPrenom() + " à faire un choix");
        questionText.setText(question.get(0).getEnonce());
        answer.setText(aiderUnAmi.getResult().getDonnee_txt());

        return rootView;
    }
}