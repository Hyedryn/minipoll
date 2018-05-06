package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.lsinf1225.g16.mini_poll.R;

public class CreationAgreementFriendsList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_agreement_friends_list, container, false);

        return rootView;
    }
}