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
import be.lsinf1225.g16.mini_poll.activity.CreationQuestionActivity;

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

        q1p.setVisibility(View.GONE);
        q2p.setVisibility(View.GONE);
        q3p.setVisibility(View.GONE);
        q4p.setVisibility(View.GONE);
        q5p.setVisibility(View.GONE);


        if(CreationQuestionActivity.question1!=null){
            q1p.setVisibility(View.VISIBLE);
            q1.setVisibility(View.VISIBLE);
            if(CreationQuestionActivity.q1image1!=null){
                q1i1.setVisibility(View.VISIBLE);
                q1i2.setVisibility(View.VISIBLE);
                q1i3.setVisibility(View.VISIBLE);
                q1i4.setVisibility(View.VISIBLE);
                q1r1.setVisibility(View.GONE);
                q1r2.setVisibility(View.GONE);
                q1r3.setVisibility(View.GONE);
                q1r4.setVisibility(View.GONE);

                q1i1.setImageBitmap(CreationQuestionActivity.q1image1);
                q1i2.setImageBitmap(CreationQuestionActivity.q1image2);
                q1i3.setImageBitmap(CreationQuestionActivity.q1image3);
                q1i4.setImageBitmap(CreationQuestionActivity.q1image4);
            }else{
                q1r1.setVisibility(View.VISIBLE);
                q1r2.setVisibility(View.VISIBLE);
                q1r3.setVisibility(View.VISIBLE);
                q1r4.setVisibility(View.VISIBLE);
                q1i1.setVisibility(View.GONE);
                q1i2.setVisibility(View.GONE);
                q1i3.setVisibility(View.GONE);
                q1i4.setVisibility(View.GONE);

                q1r1.setText(CreationQuestionActivity.q1texte1);
                q1r2.setText(CreationQuestionActivity.q1texte2);
                q1r3.setText(CreationQuestionActivity.q1texte3);
                q1r4.setText(CreationQuestionActivity.q1texte4);
            }
        }

        if(CreationQuestionActivity.question1!=null){
            q2p.setVisibility(View.VISIBLE);
            q2.setVisibility(View.VISIBLE);
            if(CreationQuestionActivity.q2image1!=null){
                q2i1.setVisibility(View.VISIBLE);
                q2i2.setVisibility(View.VISIBLE);
                q2i3.setVisibility(View.VISIBLE);
                q2i4.setVisibility(View.VISIBLE);
                q2r1.setVisibility(View.GONE);
                q2r2.setVisibility(View.GONE);
                q2r3.setVisibility(View.GONE);
                q2r4.setVisibility(View.GONE);

                q2i1.setImageBitmap(CreationQuestionActivity.q2image1);
                q2i2.setImageBitmap(CreationQuestionActivity.q2image2);
                q2i3.setImageBitmap(CreationQuestionActivity.q2image3);
                q2i4.setImageBitmap(CreationQuestionActivity.q2image4);
            }else{
                q2r1.setVisibility(View.VISIBLE);
                q2r2.setVisibility(View.VISIBLE);
                q2r3.setVisibility(View.VISIBLE);
                q2r4.setVisibility(View.VISIBLE);
                q2i1.setVisibility(View.GONE);
                q2i2.setVisibility(View.GONE);
                q2i3.setVisibility(View.GONE);
                q2i4.setVisibility(View.GONE);

                q2r1.setText(CreationQuestionActivity.q2texte1);
                q2r2.setText(CreationQuestionActivity.q2texte2);
                q2r3.setText(CreationQuestionActivity.q2texte3);
                q2r4.setText(CreationQuestionActivity.q2texte4);
            }
        }

        if(CreationQuestionActivity.question1!=null){
            q3p.setVisibility(View.VISIBLE);
            q3.setVisibility(View.VISIBLE);
            if(CreationQuestionActivity.q3image1!=null){
                q3i1.setVisibility(View.VISIBLE);
                q3i2.setVisibility(View.VISIBLE);
                q3i3.setVisibility(View.VISIBLE);
                q3i4.setVisibility(View.VISIBLE);
                q3r1.setVisibility(View.GONE);
                q3r2.setVisibility(View.GONE);
                q3r3.setVisibility(View.GONE);
                q3r4.setVisibility(View.GONE);

                q3i1.setImageBitmap(CreationQuestionActivity.q3image1);
                q3i2.setImageBitmap(CreationQuestionActivity.q3image2);
                q3i3.setImageBitmap(CreationQuestionActivity.q3image3);
                q3i4.setImageBitmap(CreationQuestionActivity.q3image4);
            }else{
                q3r1.setVisibility(View.VISIBLE);
                q3r2.setVisibility(View.VISIBLE);
                q3r3.setVisibility(View.VISIBLE);
                q3r4.setVisibility(View.VISIBLE);
                q3i1.setVisibility(View.GONE);
                q3i2.setVisibility(View.GONE);
                q3i3.setVisibility(View.GONE);
                q3i4.setVisibility(View.GONE);

                q3r1.setText(CreationQuestionActivity.q3texte1);
                q3r2.setText(CreationQuestionActivity.q3texte2);
                q3r3.setText(CreationQuestionActivity.q3texte3);
                q3r4.setText(CreationQuestionActivity.q3texte4);
            }
        }

        if(CreationQuestionActivity.question1!=null){
            q4p.setVisibility(View.VISIBLE);
            q4.setVisibility(View.VISIBLE);
            if(CreationQuestionActivity.q4image1!=null){
                q4i1.setVisibility(View.VISIBLE);
                q4i2.setVisibility(View.VISIBLE);
                q4i3.setVisibility(View.VISIBLE);
                q4i4.setVisibility(View.VISIBLE);
                q4r1.setVisibility(View.GONE);
                q4r2.setVisibility(View.GONE);
                q4r3.setVisibility(View.GONE);
                q4r4.setVisibility(View.GONE);

                q4i1.setImageBitmap(CreationQuestionActivity.q4image1);
                q4i2.setImageBitmap(CreationQuestionActivity.q4image2);
                q4i3.setImageBitmap(CreationQuestionActivity.q4image3);
                q4i4.setImageBitmap(CreationQuestionActivity.q4image4);
            }else{
                q4r1.setVisibility(View.VISIBLE);
                q4r2.setVisibility(View.VISIBLE);
                q4r3.setVisibility(View.VISIBLE);
                q4r4.setVisibility(View.VISIBLE);
                q4i1.setVisibility(View.GONE);
                q4i2.setVisibility(View.GONE);
                q4i3.setVisibility(View.GONE);
                q4i4.setVisibility(View.GONE);

                q4r1.setText(CreationQuestionActivity.q4texte1);
                q4r2.setText(CreationQuestionActivity.q4texte2);
                q4r3.setText(CreationQuestionActivity.q4texte3);
                q4r4.setText(CreationQuestionActivity.q4texte4);
            }
        }

        if(CreationQuestionActivity.question1!=null){
            q5p.setVisibility(View.VISIBLE);
            q5.setVisibility(View.VISIBLE);
            if(CreationQuestionActivity.q5image1!=null){
                q5i1.setVisibility(View.VISIBLE);
                q5i2.setVisibility(View.VISIBLE);
                q5i3.setVisibility(View.VISIBLE);
                q5i4.setVisibility(View.VISIBLE);
                q5r1.setVisibility(View.GONE);
                q5r2.setVisibility(View.GONE);
                q5r3.setVisibility(View.GONE);
                q5r4.setVisibility(View.GONE);

                q5i1.setImageBitmap(CreationQuestionActivity.q5image1);
                q5i2.setImageBitmap(CreationQuestionActivity.q5image2);
                q5i3.setImageBitmap(CreationQuestionActivity.q5image3);
                q5i4.setImageBitmap(CreationQuestionActivity.q5image4);
            }else{
                q5r1.setVisibility(View.VISIBLE);
                q5r2.setVisibility(View.VISIBLE);
                q5r3.setVisibility(View.VISIBLE);
                q5r4.setVisibility(View.VISIBLE);
                q5i1.setVisibility(View.GONE);
                q5i2.setVisibility(View.GONE);
                q5i3.setVisibility(View.GONE);
                q5i4.setVisibility(View.GONE);

                q5r1.setText(CreationQuestionActivity.q5texte1);
                q5r2.setText(CreationQuestionActivity.q5texte2);
                q5r3.setText(CreationQuestionActivity.q5texte3);
                q5r4.setText(CreationQuestionActivity.q5texte4);
            }
        }
    }
}