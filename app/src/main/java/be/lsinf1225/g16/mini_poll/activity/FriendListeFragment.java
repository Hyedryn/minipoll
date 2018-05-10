package be.lsinf1225.g16.mini_poll.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.R;

public class FriendListeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view;
        Bundle bundle = getArguments();
        int pageNumber = bundle.getInt("pageNumber");

        view = inflater.inflate(R.layout.fragment_friend_liste, container, false);
        TextView textView = (TextView)view.findViewById(R.id.pageNumber);
        String message = Integer.toString(pageNumber);
        textView.setText("Ami" + message);

        return view;
    }

}
