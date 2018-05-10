package be.lsinf1225.g16.mini_poll.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class SwipeMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        SwipeFriendList swipeFriendList= new SwipeFriendList(getSupportFragmentManager());
        viewPager.setAdapter(swipeFriendList);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);

    }
}
