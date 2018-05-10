package be.lsinf1225.g16.mini_poll.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import be.lsinf1225.g16.mini_poll.MiniPollApp;

import be.lsinf1225.g16.mini_poll.model.Utilisateur;


public class SwipeFriendList extends FragmentStatePagerAdapter{

    public SwipeFriendList(FragmentManager fm) {super (fm);}

    @Override
    public Fragment getItem(int position) {
        Fragment pageFragment = new FriendListeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pageNumber", position + 1);
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount() { return MiniPollApp.connectedUser.getListAmi().size();}
}
