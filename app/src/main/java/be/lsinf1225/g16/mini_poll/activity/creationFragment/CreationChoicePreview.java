package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationChoiceActivity;

public class CreationChoicePreview extends Fragment {

    TextView question;
    TextView r1_txt;
    TextView r2_txt;
    ImageView r1_img;
    ImageView r2_img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_choice_preview, container, false);

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  linearLayout = (LinearLayout) view.findViewById(R.id.creation_choice_fill_placeholder);
        question = (TextView) view.findViewById(R.id.creation_choice_preview_question);
        r1_txt = (TextView) view.findViewById(R.id.creation_choice_preview_r1_txt);
        r2_txt = (TextView) view.findViewById(R.id.creation_choice_preview_r2_txt);
        r1_img = (ImageView) view.findViewById(R.id.creation_choice_preview_r1_img);
        r2_img = (ImageView) view.findViewById(R.id.creation_choice_preview_r2_img);

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {



            int radioButtonID = CreationChoiceFormat.radioButtonGroup.getCheckedRadioButtonId();
            if(radioButtonID==-1){
                MiniPollApp.notifyLong(R.string.error_no_format_selected);
                CreationChoiceActivity.creationchoice.finish();
                return;
            }
            View radioButton = CreationChoiceFormat.radioButtonGroup.findViewById(radioButtonID);
            int idx = CreationChoiceFormat.radioButtonGroup.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) CreationChoiceFormat.radioButtonGroup.getChildAt(idx);
            String format = (String) btn.getText();



            question.setText(CreationChoiceActivity.question);
            if(format.equalsIgnoreCase("Image")){
                r1_img.setVisibility(View.VISIBLE);
                r2_img.setVisibility(View.VISIBLE);
                r1_txt.setVisibility(View.INVISIBLE);
                r2_txt.setVisibility(View.INVISIBLE);


            }else {
                r1_img.setVisibility(View.GONE);
                r2_img.setVisibility(View.GONE);
                r1_txt.setVisibility(View.VISIBLE);
                r2_txt.setVisibility(View.VISIBLE);
                r1_txt.setText(CreationChoiceActivity.texte1);
                r2_txt.setText(CreationChoiceActivity.texte2);


            }
        }
    }

    public void settxt(){

        int radioButtonID = CreationChoiceFormat.radioButtonGroup.getCheckedRadioButtonId();
        if(radioButtonID==-1){
            MiniPollApp.notifyLong(R.string.error_no_format_selected);
            CreationChoiceActivity.creationchoice.finish();
            return;
        }
        View radioButton = CreationChoiceFormat.radioButtonGroup.findViewById(radioButtonID);
        int idx = CreationChoiceFormat.radioButtonGroup.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) CreationChoiceFormat.radioButtonGroup.getChildAt(idx);
        String format = (String) btn.getText();



        question.setText(CreationChoiceActivity.question);
        if(format.equalsIgnoreCase("Image")){
            r1_img.setVisibility(View.VISIBLE);
            r2_img.setVisibility(View.VISIBLE);
            r1_txt.setVisibility(View.INVISIBLE);
            r2_txt.setVisibility(View.INVISIBLE);


        }else {
            r1_img.setVisibility(View.GONE);
            r2_img.setVisibility(View.GONE);
            r1_txt.setVisibility(View.VISIBLE);
            r2_txt.setVisibility(View.VISIBLE);
            r1_txt.setText(CreationChoiceActivity.texte1);
            r2_txt.setText(CreationChoiceActivity.texte2);


        }
    }
}