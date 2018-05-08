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

    public static RadioGroup radioGroup;

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


        RadioButton cb = new RadioButton(getActivity());

        RadioGroup.LayoutParams paramsCB = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);

        paramsCB.setMargins(20,20,20,20);

        cb.setPadding(3,3,3,3);
        cb.setText(u.getIdentifiant());
        cb.setBackgroundColor(getResources().getColor(R.color.dot_light_screen6));
        cb.setTextColor(Color.WHITE);
        cb.setGravity(Gravity.CENTER);
        cb.setTextSize(30f);
        cb.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        cb.setTypeface(Typeface.DEFAULT_BOLD);
        cb.setLayoutParams(paramsCB);

        radioGroup.addView(cb);

        }

    }


}