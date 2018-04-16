package be.lsinf1225.g16.mini_poll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        Intent intent = new Intent(FriendsActivity.this, FriendsListActivity.class);
        startActivity(intent);
    }
}
