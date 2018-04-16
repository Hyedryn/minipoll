package be.lsinf1225.g16.mini_poll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuSurveyCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_survey_creation);
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
