package be.lsinf1225.g16.mini_poll.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import be.lsinf1225.g16.mini_poll.R;

public class MenuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
    }

    public void friends(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, FriendsActivity.class);
        startActivity(intent);
    }

    public void profileedit(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, ProfileEditActivity.class);
        startActivity(intent);
    }

    public void profile(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void menu_choice(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, MenuChoiceActivity.class);
        startActivity(intent);
    }

    public void menu_agreement(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, MenuAgreementActivity.class);
        startActivity(intent);
    }

    public void menu_question(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, MenuQuestionActivity.class);
        startActivity(intent);
    }

    public void menu_survey_creation(View view)
    {
        Intent intent = new Intent(MenuMainActivity.this, MenuSurveyCreationActivity.class);
        startActivity(intent);
    }
}
