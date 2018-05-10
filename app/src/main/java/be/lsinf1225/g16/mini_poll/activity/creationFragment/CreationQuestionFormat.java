package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import be.lsinf1225.g16.mini_poll.R;

public class CreationQuestionFormat extends Fragment {


    public static RadioGroup g1;
    public static RadioGroup g2;
    public static RadioGroup g3;
    public static RadioGroup g4;
    public static RadioGroup g5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_question_format, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        g1 = (RadioGroup) view.findViewById(R.id.creation_question_format_q1);
        g2 = (RadioGroup) view.findViewById(R.id.creation_question_format_q2);
        g3 = (RadioGroup) view.findViewById(R.id.creation_question_format_q3);
        g4 = (RadioGroup) view.findViewById(R.id.creation_question_format_q4);
        g5 = (RadioGroup) view.findViewById(R.id.creation_question_format_q5);
    }

}