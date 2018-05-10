package be.lsinf1225.g16.mini_poll.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import be.lsinf1225.g16.mini_poll.R;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
    }

    public void friendsadd(View view)
    {
        Intent intent = new Intent(FriendsActivity.this, FriendsAddActivity.class);
        startActivity(intent);
    }

    public void friendslist(View view)
    {
        Intent intent = new Intent(FriendsActivity.this, SwipeMain.class);//FriendsListActivity
        startActivity(intent);
    }
}
