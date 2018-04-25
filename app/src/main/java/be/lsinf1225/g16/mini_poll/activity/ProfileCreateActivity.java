package be.lsinf1225.g16.mini_poll.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import be.lsinf1225.g16.mini_poll.R;

import static be.lsinf1225.g16.mini_poll.activity.ConnexionActivity.login;
import static be.lsinf1225.g16.mini_poll.activity.RegisterActivity.register;

public class ProfileCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_create);
    }

    public void mainmenu(View view)
    {
        Intent intent = new Intent(ProfileCreateActivity.this, MenuMainActivity.class);
        startActivity(intent);
        register.finish();
        login.finish();
        finish();
    }
}
