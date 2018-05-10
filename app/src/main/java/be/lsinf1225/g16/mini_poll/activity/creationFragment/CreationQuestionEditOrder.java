package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationQuestionActivity;

public class CreationQuestionEditOrder extends Fragment {


    public View view;

    CardView q1;
    CardView q2;
    CardView q3;
    CardView q4;
    CardView q5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_question_edit_order, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        q1 = (CardView) view.findViewById(R.id.creation_question_editorder_q1);
        q2 = (CardView) view.findViewById(R.id.creation_question_editorder_q2);
        q3 = (CardView) view.findViewById(R.id.creation_question_editorder_q3);
        q4 = (CardView) view.findViewById(R.id.creation_question_editorder_q4);
        q5 = (CardView) view.findViewById(R.id.creation_question_editorder_q5);

        q1.setVisibility(View.GONE);
        q2.setVisibility(View.GONE);
        q3.setVisibility(View.GONE);
        q4.setVisibility(View.GONE);
        q5.setVisibility(View.GONE);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            q1.setVisibility(View.GONE);
            q2.setVisibility(View.GONE);
            q3.setVisibility(View.GONE);
            q4.setVisibility(View.GONE);
            q5.setVisibility(View.GONE);

            if(CreationQuestionActivity.question1!=null){
                q1.setVisibility(View.VISIBLE);
            }
            if(CreationQuestionActivity.question2!=null){
                q2.setVisibility(View.VISIBLE);
            }
            if(CreationQuestionActivity.question3!=null){
                q3.setVisibility(View.VISIBLE);
            }
            if(CreationQuestionActivity.question4!=null){
                q4.setVisibility(View.VISIBLE);
            }
            if(CreationQuestionActivity.question5!=null){
                q5.setVisibility(View.VISIBLE);
            }
        }

    }

    }