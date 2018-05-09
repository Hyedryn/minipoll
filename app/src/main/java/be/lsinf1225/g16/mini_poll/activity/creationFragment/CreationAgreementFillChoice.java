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

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationAgreementActivity;
import be.lsinf1225.g16.mini_poll.activity.CreationChoiceActivity;

public class CreationAgreementFillChoice extends Fragment {

    public View view;

    public static String format;

    boolean alreadyinit = false;

    public static LinearLayout linearLayout;

    public EditText r1;
    public EditText r2;
    public EditText r3;
    public EditText r4;
    public EditText r5;
    public EditText r6;

    public ImageView i1;
    public ImageView i2;
    public ImageView i3;
    public ImageView i4;
    public ImageView i5;
    public ImageView i6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_agreement_fill_choice, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout = (LinearLayout) view.findViewById(R.id.creation_agreement_fill_placeholder);
        this.view = view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&!alreadyinit) {

            alreadyinit = true;

            int radioButtonID = CreationAgreementFormat.radioButtonGroup.getCheckedRadioButtonId();
            if(radioButtonID==-1){
                MiniPollApp.notifyLong(R.string.error_no_format_selected);
                CreationAgreementActivity.creationagreement.finish();
                return;
            }
            View radioButton = CreationAgreementFormat.radioButtonGroup.findViewById(radioButtonID);
            int idx = CreationAgreementFormat.radioButtonGroup.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) CreationAgreementFormat.radioButtonGroup.getChildAt(idx);
            format = (String) btn.getText();

            if(format.equalsIgnoreCase("Image")){

            }else {

            }

        }
    }

}