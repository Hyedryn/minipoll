package be.lsinf1225.g16.mini_poll.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import be.lsinf1225.g16.mini_poll.R;

public class RegisterActivity extends AppCompatActivity {

    public static Activity register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = this;
    }

    public void createprofile(View view)
    {
        Intent intent = new Intent(RegisterActivity.this, ProfileCreateActivity.class);
        startActivity(intent);
    }
}
