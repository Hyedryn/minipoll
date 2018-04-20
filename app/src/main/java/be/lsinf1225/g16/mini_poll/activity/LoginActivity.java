package be.lsinf1225.g16.mini_poll.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.content.Intent;

import be.lsinf1225.g16.mini_poll.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void register(View view)
    {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View view)
    {
        Intent intent = new Intent(LoginActivity.this, MenuMainActivity.class);
        startActivity(intent);
    }
}
