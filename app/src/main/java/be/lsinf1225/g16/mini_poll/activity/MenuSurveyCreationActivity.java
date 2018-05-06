package be.lsinf1225.g16.mini_poll.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import be.lsinf1225.g16.mini_poll.R;

import static be.lsinf1225.g16.mini_poll.activity.MenuSurveyCreationActivity.creationmenu;

public class MenuSurveyCreationActivity extends AppCompatActivity {

    public static Activity creationmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_survey_creation);
        creationmenu=this;
    }

    public void agreement_creation(View view)
    {

        Intent intent = new Intent(MenuSurveyCreationActivity.this, CreationAgreementActivity.class);
        startActivity(intent);
    }

    public void question_creation(View view)
    {
        Intent intent = new Intent(MenuSurveyCreationActivity.this, CreationQuestionActivity.class);
        startActivity(intent);
    }

    public void choice_creation(View view)
    {
        Intent intent = new Intent(MenuSurveyCreationActivity.this, CreationChoiceActivity.class);
        startActivity(intent);
    }
}
