package be.lsinf1225.g16.mini_poll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfileEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
    }

    public void mainmenu(View view)
    {
        Intent intent = new Intent(ProfileEditActivity.this, MenuMainActivity.class);
        startActivity(intent);
    }
}
