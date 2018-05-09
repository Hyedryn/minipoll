package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationAgreementActivity;
import be.lsinf1225.g16.mini_poll.activity.CreationQuestionActivity;

public class CreationQuestionFillChoice extends Fragment {

    public static String format;

    public static LinearLayout linearLayout;


    boolean alreadyinit = false;

    public View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_question_fill_choice, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout = (LinearLayout) view.findViewById(R.id.creation_question_fill_placeholder);
        this.view = view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&!alreadyinit) {

            alreadyinit = true;

            int radioButtonID = CreationQuestionFormat.radioButtonGroup.getCheckedRadioButtonId();
            if(radioButtonID==-1){
                MiniPollApp.notifyLong(R.string.error_no_format_selected);
                CreationQuestionActivity.creationquestion.finish();
                return;
            }
            View radioButton = CreationQuestionFormat.radioButtonGroup.findViewById(radioButtonID);
            int idx = CreationQuestionFormat.radioButtonGroup.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) CreationQuestionFormat.radioButtonGroup.getChildAt(idx);
            format = (String) btn.getText();

            if(format.equalsIgnoreCase("Image")){

            }else {

            }

        }
    }

}