package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;

public class CreationQuestionPreview extends Fragment {

    public View view;

    TextView title;

    LinearLayout q1p;
    LinearLayout q2p;
    LinearLayout q3p;
    LinearLayout q4p;
    LinearLayout q5p;

    EditText q1;
    EditText q1r1;
    EditText q1r2;
    EditText q1r3;
    EditText q1r4;
    ImageView q1i1;
    ImageView q1i2;
    ImageView q1i3;
    ImageView q1i4;

    EditText q2;
    EditText q2r1;
    EditText q2r2;
    EditText q2r3;
    EditText q2r4;
    ImageView q2i1;
    ImageView q2i2;
    ImageView q2i3;
    ImageView q2i4;

    EditText q3;
    EditText q3r1;
    EditText q3r2;
    EditText q3r3;
    EditText q3r4;
    ImageView q3i1;
    ImageView q3i2;
    ImageView q3i3;
    ImageView q3i4;

    EditText q4;
    EditText q4r1;
    EditText q4r2;
    EditText q4r3;
    EditText q4r4;
    ImageView q4i1;
    ImageView q4i2;
    ImageView q4i3;
    ImageView q4i4;

    EditText q5;
    EditText q5r1;
    EditText q5r2;
    EditText q5r3;
    EditText q5r4;
    ImageView q5i1;
    ImageView q5i2;
    ImageView q5i3;
    ImageView q5i4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_question_preview, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        title = (TextView) view.findViewById(R.id.creation_question_preview_title);

        q1p = (LinearLayout) view.findViewById(R.id.creation_question_preview_q1_placeholder);
        q2p = (LinearLayout) view.findViewById(R.id.creation_question_preview_q2_placeholder);
        q3p = (LinearLayout) view.findViewById(R.id.creation_question_preview_q3_placeholder);
        q4p = (LinearLayout) view.findViewById(R.id.creation_question_preview_q4_placeholder);
        q5p = (LinearLayout) view.findViewById(R.id.creation_question_preview_q5_placeholder);

        q1 = (EditText) view.findViewById(R.id.creation_question_preview_q1);
        q1r1 = (EditText) view.findViewById(R.id.creation_question_preview_q1_r1_txt);
        q1r2 = (EditText) view.findViewById(R.id.creation_question_preview_q1_r2_txt);
        q1r3 = (EditText) view.findViewById(R.id.creation_question_preview_q1_r3_txt);
        q1r4 = (EditText) view.findViewById(R.id.creation_question_preview_q1_r4_txt);
        q1i1 = (ImageView) view.findViewById(R.id.creation_question_preview_q1_r1_img);
        q1i2 = (ImageView) view.findViewById(R.id.creation_question_preview_q1_r2_img);
        q1i3 = (ImageView) view.findViewById(R.id.creation_question_preview_q1_r3_img);
        q1i4 = (ImageView) view.findViewById(R.id.creation_question_preview_q1_r4_img);

        q2 = (EditText) view.findViewById(R.id.creation_question_preview_q2);
        q2r1 = (EditText) view.findViewById(R.id.creation_question_preview_q2_r1_txt);
        q2r2 = (EditText) view.findViewById(R.id.creation_question_preview_q2_r2_txt);
        q2r3 = (EditText) view.findViewById(R.id.creation_question_preview_q2_r3_txt);
        q2r4 = (EditText) view.findViewById(R.id.creation_question_preview_q2_r4_txt);
        q2i1 = (ImageView) view.findViewById(R.id.creation_question_preview_q2_r1_img);
        q2i2 = (ImageView) view.findViewById(R.id.creation_question_preview_q2_r2_img);
        q2i3 = (ImageView) view.findViewById(R.id.creation_question_preview_q2_r3_img);
        q2i4 = (ImageView) view.findViewById(R.id.creation_question_preview_q2_r4_img);

        q3 = (EditText) view.findViewById(R.id.creation_question_preview_q3);
        q3r1 = (EditText) view.findViewById(R.id.creation_question_preview_q3_r1_txt);
        q3r2 = (EditText) view.findViewById(R.id.creation_question_preview_q3_r2_txt);
        q3r3 = (EditText) view.findViewById(R.id.creation_question_preview_q3_r3_txt);
        q3r4 = (EditText) view.findViewById(R.id.creation_question_preview_q3_r4_txt);
        q3i1 = (ImageView) view.findViewById(R.id.creation_question_preview_q3_r1_img);
        q3i2 = (ImageView) view.findViewById(R.id.creation_question_preview_q3_r2_img);
        q3i3 = (ImageView) view.findViewById(R.id.creation_question_preview_q3_r3_img);
        q3i4 = (ImageView) view.findViewById(R.id.creation_question_preview_q3_r4_img);

        q4 = (EditText) view.findViewById(R.id.creation_question_preview_q4);
        q4r1 = (EditText) view.findViewById(R.id.creation_question_preview_q4_r1_txt);
        q4r2 = (EditText) view.findViewById(R.id.creation_question_preview_q4_r2_txt);
        q4r3 = (EditText) view.findViewById(R.id.creation_question_preview_q4_r3_txt);
        q4r4 = (EditText) view.findViewById(R.id.creation_question_preview_q4_r4_txt);
        q4i1 = (ImageView) view.findViewById(R.id.creation_question_preview_q4_r1_img);
        q4i2 = (ImageView) view.findViewById(R.id.creation_question_preview_q4_r2_img);
        q4i3 = (ImageView) view.findViewById(R.id.creation_question_preview_q4_r3_img);
        q4i4 = (ImageView) view.findViewById(R.id.creation_question_preview_q4_r4_img);

        q5 = (EditText) view.findViewById(R.id.creation_question_preview_q5);
        q5r1 = (EditText) view.findViewById(R.id.creation_question_preview_q5_r1_txt);
        q5r2 = (EditText) view.findViewById(R.id.creation_question_preview_q5_r2_txt);
        q5r3 = (EditText) view.findViewById(R.id.creation_question_preview_q5_r3_txt);
        q5r4 = (EditText) view.findViewById(R.id.creation_question_preview_q5_r4_txt);
        q5i1 = (ImageView) view.findViewById(R.id.creation_question_preview_q5_r1_img);
        q5i2 = (ImageView) view.findViewById(R.id.creation_question_preview_q5_r2_img);
        q5i3 = (ImageView) view.findViewById(R.id.creation_question_preview_q5_r3_img);
        q5i4 = (ImageView) view.findViewById(R.id.creation_question_preview_q5_r4_img);
        
        title.setText("Questionnaire de "+ MiniPollApp.connectedUser.getIdentifiant());

    }

    public void settxt() {
    }
}