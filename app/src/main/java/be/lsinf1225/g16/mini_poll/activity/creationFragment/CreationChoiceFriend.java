package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class CreationChoiceFriend extends Fragment {

    RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_choice_friend, container, false);

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup = (RadioGroup) view.findViewById(R.id.creation_choice_placeholder);

        displayFriend();

    }

    private void displayFriend(){



        for(Utilisateur u: MiniPollApp.connectedUser.getListAmi()){

        CardView c = new CardView(getActivity());
        LinearLayout l = new LinearLayout(getActivity());
        TextView t = new TextView(getActivity());
        RadioButton cb = new RadioButton(getActivity());

        CardView.LayoutParams paramsL = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);

        RadioGroup.LayoutParams paramsC = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);

        paramsC.setMargins(20,20,20,20);

        LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);

        LinearLayout.LayoutParams paramsCB = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

        c.setMaxCardElevation(5);
        c.setCardElevation(2.0f);
        c.setRadius(2.0f);
        c.setCardBackgroundColor(getResources().getColor(R.color.CardViewCreationBackground));
        c.setLayoutParams(paramsC);

        l.setOrientation(LinearLayout.HORIZONTAL);
        l.setBackgroundColor(getResources().getColor(R.color.dot_light_screen6));
        l.setLayoutParams(paramsL);

        t.setText(u.getIdentifiant());
        t.setGravity(Gravity.CENTER);
        t.setTextColor(Color.WHITE);
        t.setTextSize(30f);

        t.setTypeface(Typeface.DEFAULT_BOLD);
        t.setLayoutParams(paramsT);

        cb.setLayoutParams(paramsCB);

        l.addView(t);
        l.addView(cb);
        c.addView(l);


        radioGroup.addView(c);

        }

    }


}