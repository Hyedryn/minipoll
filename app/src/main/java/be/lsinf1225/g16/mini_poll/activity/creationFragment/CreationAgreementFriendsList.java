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
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class CreationAgreementFriendsList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_agreement_friends_list, container, false);

        return rootView;
    }

    public static LinearLayout linearlayout;

    public static ArrayList<String> selectedfriends;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearlayout = (LinearLayout) view.findViewById(R.id.creation_agreement_friend_placeholder);
        selectedfriends = new ArrayList<String>();
        displayFriend();

    }

    private void displayFriend(){

        for(Utilisateur u: MiniPollApp.connectedUser.getListAmi()){

            CardView c = new CardView(getActivity());
            LinearLayout l = new LinearLayout(getActivity());
            final CheckBox cb = new CheckBox(getActivity());

            CardView.LayoutParams paramsL = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);

            LinearLayout.LayoutParams paramsC = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            paramsC.setMargins(20,20,20,20);

            LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);

            LinearLayout.LayoutParams paramsCB = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            paramsCB.setMargins(20,20,20,20);

            c.setMaxCardElevation(15);
            c.setCardElevation(5.0f);
            c.setRadius(5.0f);
            c.setCardBackgroundColor(getResources().getColor(R.color.CardViewCreationBackground));
            c.setLayoutParams(paramsC);

            l.setOrientation(LinearLayout.HORIZONTAL);
            l.setBackgroundColor(getResources().getColor(R.color.dot_light_screen6));
            l.setLayoutParams(paramsL);

            cb.setLayoutParams(paramsCB);
            cb.setText(u.getIdentifiant());
            cb.setGravity(Gravity.CENTER);
            cb.setTextColor(Color.WHITE);
            cb.setTextSize(30f);

            cb.setTypeface(Typeface.DEFAULT_BOLD);

            cb.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(cb.isChecked())
                    {
                        selectedfriends.add(cb.getText().toString());
                    }
                    else
                    {
                        selectedfriends.remove(cb.getText().toString());
                    }

                }
            });

            l.addView(cb);
            c.addView(l);


            linearlayout.addView(c);

        }

    }

}