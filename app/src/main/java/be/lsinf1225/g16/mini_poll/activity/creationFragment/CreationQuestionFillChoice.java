package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationAgreementActivity;
import be.lsinf1225.g16.mini_poll.activity.CreationQuestionActivity;

import static be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFormat.g1;
import static be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFormat.g2;
import static be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFormat.g3;
import static be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFormat.g4;
import static be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFormat.g5;

public class CreationQuestionFillChoice extends Fragment {

    public static String format;

    public static LinearLayout linearLayout;

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

    public static int RESULT_LOAD_IMAGE = 1;
    public static ImageView imageView;

    boolean alreadyinit = false;

    public View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_question_fill_choice, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout = (LinearLayout) view.findViewById(R.id.creation_question_fill_placeholder);
        this.view = view;

        q1p = (LinearLayout) view.findViewById(R.id.creation_question_fill_q1_placeholder);
        q2p = (LinearLayout) view.findViewById(R.id.creation_question_fill_q2_placeholder);
        q3p = (LinearLayout) view.findViewById(R.id.creation_question_fill_q3_placeholder);
        q4p = (LinearLayout) view.findViewById(R.id.creation_question_fill_q4_placeholder);
        q5p = (LinearLayout) view.findViewById(R.id.creation_question_fill_q5_placeholder);

        q1 = (EditText) view.findViewById(R.id.creation_question_fill_q1);
        q1r1 = (EditText) view.findViewById(R.id.creation_question_fill_q1_r1_txt);
        q1r2 = (EditText) view.findViewById(R.id.creation_question_fill_q1_r2_txt);
        q1r3 = (EditText) view.findViewById(R.id.creation_question_fill_q1_r3_txt);
        q1r4 = (EditText) view.findViewById(R.id.creation_question_fill_q1_r4_txt);
        q1i1 = (ImageView) view.findViewById(R.id.creation_question_fill_q1_r1_img);
        q1i2 = (ImageView) view.findViewById(R.id.creation_question_fill_q1_r2_img);
        q1i3 = (ImageView) view.findViewById(R.id.creation_question_fill_q1_r3_img);
        q1i4 = (ImageView) view.findViewById(R.id.creation_question_fill_q1_r4_img);

        q2 = (EditText) view.findViewById(R.id.creation_question_fill_q2);
        q2r1 = (EditText) view.findViewById(R.id.creation_question_fill_q2_r1_txt);
        q2r2 = (EditText) view.findViewById(R.id.creation_question_fill_q2_r2_txt);
        q2r3 = (EditText) view.findViewById(R.id.creation_question_fill_q2_r3_txt);
        q2r4 = (EditText) view.findViewById(R.id.creation_question_fill_q2_r4_txt);
        q2i1 = (ImageView) view.findViewById(R.id.creation_question_fill_q2_r1_img);
        q2i2 = (ImageView) view.findViewById(R.id.creation_question_fill_q2_r2_img);
        q2i3 = (ImageView) view.findViewById(R.id.creation_question_fill_q2_r3_img);
        q2i4 = (ImageView) view.findViewById(R.id.creation_question_fill_q2_r4_img);

        q3 = (EditText) view.findViewById(R.id.creation_question_fill_q3);
        q3r1 = (EditText) view.findViewById(R.id.creation_question_fill_q3_r1_txt);
        q3r2 = (EditText) view.findViewById(R.id.creation_question_fill_q3_r2_txt);
        q3r3 = (EditText) view.findViewById(R.id.creation_question_fill_q3_r3_txt);
        q3r4 = (EditText) view.findViewById(R.id.creation_question_fill_q3_r4_txt);
        q3i1 = (ImageView) view.findViewById(R.id.creation_question_fill_q3_r1_img);
        q3i2 = (ImageView) view.findViewById(R.id.creation_question_fill_q3_r2_img);
        q3i3 = (ImageView) view.findViewById(R.id.creation_question_fill_q3_r3_img);
        q3i4 = (ImageView) view.findViewById(R.id.creation_question_fill_q3_r4_img);

        q4 = (EditText) view.findViewById(R.id.creation_question_fill_q4);
        q4r1 = (EditText) view.findViewById(R.id.creation_question_fill_q4_r1_txt);
        q4r2 = (EditText) view.findViewById(R.id.creation_question_fill_q4_r2_txt);
        q4r3 = (EditText) view.findViewById(R.id.creation_question_fill_q4_r3_txt);
        q4r4 = (EditText) view.findViewById(R.id.creation_question_fill_q4_r4_txt);
        q4i1 = (ImageView) view.findViewById(R.id.creation_question_fill_q4_r1_img);
        q4i2 = (ImageView) view.findViewById(R.id.creation_question_fill_q4_r2_img);
        q4i3 = (ImageView) view.findViewById(R.id.creation_question_fill_q4_r3_img);
        q4i4 = (ImageView) view.findViewById(R.id.creation_question_fill_q4_r4_img);

        q5 = (EditText) view.findViewById(R.id.creation_question_fill_q5);
        q5r1 = (EditText) view.findViewById(R.id.creation_question_fill_q5_r1_txt);
        q5r2 = (EditText) view.findViewById(R.id.creation_question_fill_q5_r2_txt);
        q5r3 = (EditText) view.findViewById(R.id.creation_question_fill_q5_r3_txt);
        q5r4 = (EditText) view.findViewById(R.id.creation_question_fill_q5_r4_txt);
        q5i1 = (ImageView) view.findViewById(R.id.creation_question_fill_q5_r1_img);
        q5i2 = (ImageView) view.findViewById(R.id.creation_question_fill_q5_r2_img);
        q5i3 = (ImageView) view.findViewById(R.id.creation_question_fill_q5_r3_img);
        q5i4 = (ImageView) view.findViewById(R.id.creation_question_fill_q5_r4_img);


        q1i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q1i1;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });

        q1i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q1i2;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        q1i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q1i3;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        q1i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q1i4;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });





        q2i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q2i1;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });

        q2i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q2i2;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        q2i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q2i3;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        q2i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q2i4;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });




        q3i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q3i1;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });

        q3i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q3i2;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        q3i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q3i3;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        q3i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q3i4;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });



        q4i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q4i1;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });

        q4i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q4i2;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        q4i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q4i3;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        q4i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q4i4;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });




        q5i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q5i1;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);

            }
        });

        q5i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q5i2;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        q5i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q5i3;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        q5i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView=q5i4;
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                getActivity().startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            alreadyinit = true;

            int txt = 0;
            int img = 0;


            q1p.setVisibility(View.GONE);
            q2p.setVisibility(View.GONE);
            q3p.setVisibility(View.GONE);
            q4p.setVisibility(View.GONE);
            q5p.setVisibility(View.GONE);

            if(g1.getCheckedRadioButtonId()==R.id.creation_question_format_q1_img){
                img++;
                q1p.setVisibility(View.VISIBLE);
                q1.setVisibility(View.VISIBLE);
                q1i1.setVisibility(View.VISIBLE);
                q1i2.setVisibility(View.VISIBLE);
                q1i3.setVisibility(View.VISIBLE);
                q1i4.setVisibility(View.VISIBLE);
                q1r1.setVisibility(View.GONE);
                q1r2.setVisibility(View.GONE);
                q1r3.setVisibility(View.GONE);
                q1r4.setVisibility(View.GONE);
            }else if(g1.getCheckedRadioButtonId()==R.id.creation_question_format_q1_txt){
                txt++;
                q1p.setVisibility(View.VISIBLE);
                q1.setVisibility(View.VISIBLE);
                q1r1.setVisibility(View.VISIBLE);
                q1r2.setVisibility(View.VISIBLE);
                q1r3.setVisibility(View.VISIBLE);
                q1r4.setVisibility(View.VISIBLE);
                q1i1.setVisibility(View.GONE);
                q1i2.setVisibility(View.GONE);
                q1i3.setVisibility(View.GONE);
                q1i4.setVisibility(View.GONE);
            }

            if(g2.getCheckedRadioButtonId()==R.id.creation_question_format_q2_img){
                img++;
                if(img+txt==1){
                    q1p.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.VISIBLE);
                    q1i1.setVisibility(View.VISIBLE);
                    q1i2.setVisibility(View.VISIBLE);
                    q1i3.setVisibility(View.VISIBLE);
                    q1i4.setVisibility(View.VISIBLE);
                    q1r1.setVisibility(View.GONE);
                    q1r2.setVisibility(View.GONE);
                    q1r3.setVisibility(View.GONE);
                    q1r4.setVisibility(View.GONE);
                }else if(img+txt==2){
                    q2p.setVisibility(View.VISIBLE);
                    q2.setVisibility(View.VISIBLE);
                    q2i1.setVisibility(View.VISIBLE);
                    q2i2.setVisibility(View.VISIBLE);
                    q2i3.setVisibility(View.VISIBLE);
                    q2i4.setVisibility(View.VISIBLE);
                    q2r1.setVisibility(View.GONE);
                    q2r2.setVisibility(View.GONE);
                    q2r3.setVisibility(View.GONE);
                    q2r4.setVisibility(View.GONE);
                }
            }else if(g2.getCheckedRadioButtonId()==R.id.creation_question_format_q2_txt){
                txt++;
                if(img+txt==1){
                    q1p.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.VISIBLE);
                    q1r1.setVisibility(View.VISIBLE);
                    q1r2.setVisibility(View.VISIBLE);
                    q1r3.setVisibility(View.VISIBLE);
                    q1r4.setVisibility(View.VISIBLE);
                    q1i1.setVisibility(View.GONE);
                    q1i2.setVisibility(View.GONE);
                    q1i3.setVisibility(View.GONE);
                    q1i4.setVisibility(View.GONE);
                }else if(img+txt==2){
                    q2p.setVisibility(View.VISIBLE);
                    q2.setVisibility(View.VISIBLE);
                    q2r1.setVisibility(View.VISIBLE);
                    q2r2.setVisibility(View.VISIBLE);
                    q2r3.setVisibility(View.VISIBLE);
                    q2r4.setVisibility(View.VISIBLE);
                    q2i1.setVisibility(View.GONE);
                    q2i2.setVisibility(View.GONE);
                    q2i3.setVisibility(View.GONE);
                    q2i4.setVisibility(View.GONE);
                }
            }


            if(g3.getCheckedRadioButtonId()==R.id.creation_question_format_q3_img){
                img++;
                if(img+txt==1){
                    q1p.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.VISIBLE);
                    q1i1.setVisibility(View.VISIBLE);
                    q1i2.setVisibility(View.VISIBLE);
                    q1i3.setVisibility(View.VISIBLE);
                    q1i4.setVisibility(View.VISIBLE);
                    q1r1.setVisibility(View.GONE);
                    q1r2.setVisibility(View.GONE);
                    q1r3.setVisibility(View.GONE);
                    q1r4.setVisibility(View.GONE);
                }else if(img+txt==2){
                    q2p.setVisibility(View.VISIBLE);
                    q2.setVisibility(View.VISIBLE);
                    q2i1.setVisibility(View.VISIBLE);
                    q2i2.setVisibility(View.VISIBLE);
                    q2i3.setVisibility(View.VISIBLE);
                    q2i4.setVisibility(View.VISIBLE);
                    q2r1.setVisibility(View.GONE);
                    q2r2.setVisibility(View.GONE);
                    q2r3.setVisibility(View.GONE);
                    q2r4.setVisibility(View.GONE);
                }else if(img+txt==3){
                    q3p.setVisibility(View.VISIBLE);
                    q3.setVisibility(View.VISIBLE);
                    q3i1.setVisibility(View.VISIBLE);
                    q3i2.setVisibility(View.VISIBLE);
                    q3i3.setVisibility(View.VISIBLE);
                    q3i4.setVisibility(View.VISIBLE);
                    q3r1.setVisibility(View.GONE);
                    q3r2.setVisibility(View.GONE);
                    q3r3.setVisibility(View.GONE);
                    q3r4.setVisibility(View.GONE);
                }
            }else if(g3.getCheckedRadioButtonId()==R.id.creation_question_format_q3_txt){
                txt++;
                if(img+txt==1){
                    q1p.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.VISIBLE);
                    q1r1.setVisibility(View.VISIBLE);
                    q1r2.setVisibility(View.VISIBLE);
                    q1r3.setVisibility(View.VISIBLE);
                    q1r4.setVisibility(View.VISIBLE);
                    q1i1.setVisibility(View.GONE);
                    q1i2.setVisibility(View.GONE);
                    q1i3.setVisibility(View.GONE);
                    q1i4.setVisibility(View.GONE);
                }else if(img+txt==2){
                    q2p.setVisibility(View.VISIBLE);
                    q2.setVisibility(View.VISIBLE);
                    q2r1.setVisibility(View.VISIBLE);
                    q2r2.setVisibility(View.VISIBLE);
                    q2r3.setVisibility(View.VISIBLE);
                    q2r4.setVisibility(View.VISIBLE);
                    q2i1.setVisibility(View.GONE);
                    q2i2.setVisibility(View.GONE);
                    q2i3.setVisibility(View.GONE);
                    q2i4.setVisibility(View.GONE);
                }else if(img+txt==3){
                    q3p.setVisibility(View.VISIBLE);
                    q3.setVisibility(View.VISIBLE);
                    q3r1.setVisibility(View.VISIBLE);
                    q3r2.setVisibility(View.VISIBLE);
                    q3r3.setVisibility(View.VISIBLE);
                    q3r4.setVisibility(View.VISIBLE);
                    q3i1.setVisibility(View.GONE);
                    q3i2.setVisibility(View.GONE);
                    q3i3.setVisibility(View.GONE);
                    q3i4.setVisibility(View.GONE);
                }
            }


            if(g4.getCheckedRadioButtonId()==R.id.creation_question_format_q4_img){
                img++;
                if(img+txt==1){
                    q1p.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.VISIBLE);
                    q1i1.setVisibility(View.VISIBLE);
                    q1i2.setVisibility(View.VISIBLE);
                    q1i3.setVisibility(View.VISIBLE);
                    q1i4.setVisibility(View.VISIBLE);
                    q1r1.setVisibility(View.GONE);
                    q1r2.setVisibility(View.GONE);
                    q1r3.setVisibility(View.GONE);
                    q1r4.setVisibility(View.GONE);
                }else if(img+txt==2){
                    q2p.setVisibility(View.VISIBLE);
                    q2.setVisibility(View.VISIBLE);
                    q2i1.setVisibility(View.VISIBLE);
                    q2i2.setVisibility(View.VISIBLE);
                    q2i3.setVisibility(View.VISIBLE);
                    q2i4.setVisibility(View.VISIBLE);
                    q2r1.setVisibility(View.GONE);
                    q2r2.setVisibility(View.GONE);
                    q2r3.setVisibility(View.GONE);
                    q2r4.setVisibility(View.GONE);
                }else if(img+txt==3){
                    q3p.setVisibility(View.VISIBLE);
                    q3.setVisibility(View.VISIBLE);
                    q3i1.setVisibility(View.VISIBLE);
                    q3i2.setVisibility(View.VISIBLE);
                    q3i3.setVisibility(View.VISIBLE);
                    q3i4.setVisibility(View.VISIBLE);
                    q3r1.setVisibility(View.GONE);
                    q3r2.setVisibility(View.GONE);
                    q3r3.setVisibility(View.GONE);
                    q3r4.setVisibility(View.GONE);
                }else if(img+txt==4){
                    q4p.setVisibility(View.VISIBLE);
                    q4.setVisibility(View.VISIBLE);
                    q4i1.setVisibility(View.VISIBLE);
                    q4i2.setVisibility(View.VISIBLE);
                    q4i3.setVisibility(View.VISIBLE);
                    q4i4.setVisibility(View.VISIBLE);
                    q4r1.setVisibility(View.GONE);
                    q4r2.setVisibility(View.GONE);
                    q4r3.setVisibility(View.GONE);
                    q4r4.setVisibility(View.GONE);
                }
            }else if(g4.getCheckedRadioButtonId()==R.id.creation_question_format_q4_txt){
                txt++;
                if(img+txt==1){
                    q1p.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.VISIBLE);
                    q1r1.setVisibility(View.VISIBLE);
                    q1r2.setVisibility(View.VISIBLE);
                    q1r3.setVisibility(View.VISIBLE);
                    q1r4.setVisibility(View.VISIBLE);
                    q1i1.setVisibility(View.GONE);
                    q1i2.setVisibility(View.GONE);
                    q1i3.setVisibility(View.GONE);
                    q1i4.setVisibility(View.GONE);
                }else if(img+txt==2){
                    q2p.setVisibility(View.VISIBLE);
                    q2.setVisibility(View.VISIBLE);
                    q2r1.setVisibility(View.VISIBLE);
                    q2r2.setVisibility(View.VISIBLE);
                    q2r3.setVisibility(View.VISIBLE);
                    q2r4.setVisibility(View.VISIBLE);
                    q2i1.setVisibility(View.GONE);
                    q2i2.setVisibility(View.GONE);
                    q2i3.setVisibility(View.GONE);
                    q2i4.setVisibility(View.GONE);
                }else if(img+txt==3){
                    q3p.setVisibility(View.VISIBLE);
                    q3.setVisibility(View.VISIBLE);
                    q3r1.setVisibility(View.VISIBLE);
                    q3r2.setVisibility(View.VISIBLE);
                    q3r3.setVisibility(View.VISIBLE);
                    q3r4.setVisibility(View.VISIBLE);
                    q3i1.setVisibility(View.GONE);
                    q3i2.setVisibility(View.GONE);
                    q3i3.setVisibility(View.GONE);
                    q3i4.setVisibility(View.GONE);
                }else if(img+txt==4){
                    q4p.setVisibility(View.VISIBLE);
                    q4.setVisibility(View.VISIBLE);
                    q4r1.setVisibility(View.VISIBLE);
                    q4r2.setVisibility(View.VISIBLE);
                    q4r3.setVisibility(View.VISIBLE);
                    q4r4.setVisibility(View.VISIBLE);
                    q4i1.setVisibility(View.GONE);
                    q4i2.setVisibility(View.GONE);
                    q4i3.setVisibility(View.GONE);
                    q4i4.setVisibility(View.GONE);
                }
            }

            if(g5.getCheckedRadioButtonId()==R.id.creation_question_format_q5_img){
                img++;
                if(img+txt==1){
                    q1p.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.VISIBLE);
                    q1i1.setVisibility(View.VISIBLE);
                    q1i2.setVisibility(View.VISIBLE);
                    q1i3.setVisibility(View.VISIBLE);
                    q1i4.setVisibility(View.VISIBLE);
                    q1r1.setVisibility(View.GONE);
                    q1r2.setVisibility(View.GONE);
                    q1r3.setVisibility(View.GONE);
                    q1r4.setVisibility(View.GONE);
                }else if(img+txt==2){
                    q2p.setVisibility(View.VISIBLE);
                    q2.setVisibility(View.VISIBLE);
                    q2i1.setVisibility(View.VISIBLE);
                    q2i2.setVisibility(View.VISIBLE);
                    q2i3.setVisibility(View.VISIBLE);
                    q2i4.setVisibility(View.VISIBLE);
                    q2r1.setVisibility(View.GONE);
                    q2r2.setVisibility(View.GONE);
                    q2r3.setVisibility(View.GONE);
                    q2r4.setVisibility(View.GONE);
                }else if(img+txt==3){
                    q3p.setVisibility(View.VISIBLE);
                    q3.setVisibility(View.VISIBLE);
                    q3i1.setVisibility(View.VISIBLE);
                    q3i2.setVisibility(View.VISIBLE);
                    q3i3.setVisibility(View.VISIBLE);
                    q3i4.setVisibility(View.VISIBLE);
                    q3r1.setVisibility(View.GONE);
                    q3r2.setVisibility(View.GONE);
                    q3r3.setVisibility(View.GONE);
                    q3r4.setVisibility(View.GONE);
                }else if(img+txt==4){
                    q4p.setVisibility(View.VISIBLE);
                    q4.setVisibility(View.VISIBLE);
                    q4i1.setVisibility(View.VISIBLE);
                    q4i2.setVisibility(View.VISIBLE);
                    q4i3.setVisibility(View.VISIBLE);
                    q4i4.setVisibility(View.VISIBLE);
                    q4r1.setVisibility(View.GONE);
                    q4r2.setVisibility(View.GONE);
                    q4r3.setVisibility(View.GONE);
                    q4r4.setVisibility(View.GONE);
                }else if(img+txt==5){
                    q5p.setVisibility(View.VISIBLE);
                    q5.setVisibility(View.VISIBLE);
                    q5i1.setVisibility(View.VISIBLE);
                    q5i2.setVisibility(View.VISIBLE);
                    q5i3.setVisibility(View.VISIBLE);
                    q5i4.setVisibility(View.VISIBLE);
                    q5r1.setVisibility(View.GONE);
                    q5r2.setVisibility(View.GONE);
                    q5r3.setVisibility(View.GONE);
                    q5r4.setVisibility(View.GONE);
                }
            }else if(g5.getCheckedRadioButtonId()==R.id.creation_question_format_q5_txt){
                txt++;
                if(img+txt==1){
                    q1p.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.VISIBLE);
                    q1r1.setVisibility(View.VISIBLE);
                    q1r2.setVisibility(View.VISIBLE);
                    q1r3.setVisibility(View.VISIBLE);
                    q1r4.setVisibility(View.VISIBLE);
                    q1i1.setVisibility(View.GONE);
                    q1i2.setVisibility(View.GONE);
                    q1i3.setVisibility(View.GONE);
                    q1i4.setVisibility(View.GONE);
                }else if(img+txt==2){
                    q2p.setVisibility(View.VISIBLE);
                    q2.setVisibility(View.VISIBLE);
                    q2r1.setVisibility(View.VISIBLE);
                    q2r2.setVisibility(View.VISIBLE);
                    q2r3.setVisibility(View.VISIBLE);
                    q2r4.setVisibility(View.VISIBLE);
                    q2i1.setVisibility(View.GONE);
                    q2i2.setVisibility(View.GONE);
                    q2i3.setVisibility(View.GONE);
                    q2i4.setVisibility(View.GONE);
                }else if(img+txt==3){
                    q3p.setVisibility(View.VISIBLE);
                    q3.setVisibility(View.VISIBLE);
                    q3r1.setVisibility(View.VISIBLE);
                    q3r2.setVisibility(View.VISIBLE);
                    q3r3.setVisibility(View.VISIBLE);
                    q3r4.setVisibility(View.VISIBLE);
                    q3i1.setVisibility(View.GONE);
                    q3i2.setVisibility(View.GONE);
                    q3i3.setVisibility(View.GONE);
                    q3i4.setVisibility(View.GONE);
                }else if(img+txt==4){
                    q4p.setVisibility(View.VISIBLE);
                    q4.setVisibility(View.VISIBLE);
                    q4r1.setVisibility(View.VISIBLE);
                    q4r2.setVisibility(View.VISIBLE);
                    q4r3.setVisibility(View.VISIBLE);
                    q4r4.setVisibility(View.VISIBLE);
                    q4i1.setVisibility(View.GONE);
                    q4i2.setVisibility(View.GONE);
                    q4i3.setVisibility(View.GONE);
                    q4i4.setVisibility(View.GONE);
                }else if(img+txt==5){
                    q5p.setVisibility(View.VISIBLE);
                    q5.setVisibility(View.VISIBLE);
                    q5r1.setVisibility(View.VISIBLE);
                    q5r2.setVisibility(View.VISIBLE);
                    q5r3.setVisibility(View.VISIBLE);
                    q5r4.setVisibility(View.VISIBLE);
                    q5i1.setVisibility(View.GONE);
                    q5i2.setVisibility(View.GONE);
                    q5i3.setVisibility(View.GONE);
                    q5i4.setVisibility(View.GONE);
                }
            }


            if(img+txt<1){
                MiniPollApp.notifyLong(R.string.error_not_enought_question);
               // CreationQuestionActivity.creationquestion.finish();
                return;
            }

        }
    }

    public void save(){



        if(q1p.getVisibility()==View.VISIBLE){
            CreationQuestionActivity.question1 = q1.getText().toString();
            if(g1.getCheckedRadioButtonId()==R.id.creation_question_format_q1_img){
                q1i1.buildDrawingCache();
                CreationQuestionActivity.q1image1 = q1i1.getDrawingCache().copy(q1i1.getDrawingCache().getConfig(), true);
                q1i2.buildDrawingCache();
                CreationQuestionActivity.q1image2 = q1i2.getDrawingCache().copy(q1i2.getDrawingCache().getConfig(), true);
                q1i3.buildDrawingCache();
                CreationQuestionActivity.q1image3 = q1i3.getDrawingCache().copy(q1i3.getDrawingCache().getConfig(), true);
                q1i4.buildDrawingCache();
                CreationQuestionActivity.q1image4 = q1i4.getDrawingCache().copy(q1i4.getDrawingCache().getConfig(), true);
            }else{
                CreationQuestionActivity.q1texte1 = q1r1.getText().toString();
                CreationQuestionActivity.q1texte2 = q1r2.getText().toString();
                CreationQuestionActivity.q1texte3 = q1r3.getText().toString();
                CreationQuestionActivity.q1texte4 = q1r4.getText().toString();
            }
        }
        if(q2p.getVisibility()==View.VISIBLE){
            CreationQuestionActivity.question2 = q2.getText().toString();
            if(g2.getCheckedRadioButtonId()==R.id.creation_question_format_q2_img){
                q2i1.buildDrawingCache();
                CreationQuestionActivity.q2image1 = q2i1.getDrawingCache().copy(q2i1.getDrawingCache().getConfig(), true);
                q2i2.buildDrawingCache();
                CreationQuestionActivity.q2image2 = q2i2.getDrawingCache().copy(q2i2.getDrawingCache().getConfig(), true);
                q2i3.buildDrawingCache();
                CreationQuestionActivity.q2image3 = q2i3.getDrawingCache().copy(q2i3.getDrawingCache().getConfig(), true);
                q2i4.buildDrawingCache();
                CreationQuestionActivity.q2image4 = q2i4.getDrawingCache().copy(q2i4.getDrawingCache().getConfig(), true);
            }else{
                CreationQuestionActivity.q2texte1 = q2r1.getText().toString();
                CreationQuestionActivity.q2texte2 = q2r2.getText().toString();
                CreationQuestionActivity.q2texte3 = q2r3.getText().toString();
                CreationQuestionActivity.q2texte4 = q2r4.getText().toString();
            }
        }
        if(q3p.getVisibility()==View.VISIBLE){
            CreationQuestionActivity.question3 = q3.getText().toString();
            if(g3.getCheckedRadioButtonId()==R.id.creation_question_format_q3_img){
                q3i1.buildDrawingCache();
                CreationQuestionActivity.q3image1 = q3i1.getDrawingCache().copy(q3i1.getDrawingCache().getConfig(), true);
                q3i2.buildDrawingCache();
                CreationQuestionActivity.q3image2 = q3i2.getDrawingCache().copy(q3i2.getDrawingCache().getConfig(), true);
                q3i3.buildDrawingCache();
                CreationQuestionActivity.q3image3 = q3i3.getDrawingCache().copy(q3i3.getDrawingCache().getConfig(), true);
                q3i4.buildDrawingCache();
                CreationQuestionActivity.q3image4 = q3i4.getDrawingCache().copy(q3i4.getDrawingCache().getConfig(), true);
            }else{
                CreationQuestionActivity.q3texte1 = q3r1.getText().toString();
                CreationQuestionActivity.q3texte2 = q3r2.getText().toString();
                CreationQuestionActivity.q3texte3 = q3r3.getText().toString();
                CreationQuestionActivity.q3texte4 = q3r4.getText().toString();
            }
        }
        if(q4p.getVisibility()==View.VISIBLE){
            CreationQuestionActivity.question4 = q4.getText().toString();
            if(g4.getCheckedRadioButtonId()==R.id.creation_question_format_q4_img){
                q4i1.setDrawingCacheEnabled(true);
                q4i1.buildDrawingCache();
                CreationQuestionActivity.q4image1 = q4i1.getDrawingCache().copy(q4i1.getDrawingCache().getConfig(), true);
                q4i2.setDrawingCacheEnabled(true);
                q4i2.buildDrawingCache();
                CreationQuestionActivity.q4image2 = q4i2.getDrawingCache().copy(q4i2.getDrawingCache().getConfig(), true);
                q4i3.setDrawingCacheEnabled(true);
                q4i3.buildDrawingCache();
                CreationQuestionActivity.q4image3 = q4i3.getDrawingCache().copy(q4i3.getDrawingCache().getConfig(), true);
                q4i4.setDrawingCacheEnabled(true);
                q4i4.buildDrawingCache();
                CreationQuestionActivity.q4image4 = q4i4.getDrawingCache().copy(q4i4.getDrawingCache().getConfig(), true);
            }else{
                CreationQuestionActivity.q4texte1 = q4r1.getText().toString();
                CreationQuestionActivity.q4texte2 = q4r2.getText().toString();
                CreationQuestionActivity.q4texte3 = q4r3.getText().toString();
                CreationQuestionActivity.q4texte4 = q4r4.getText().toString();
            }
        }
        if(q5p.getVisibility()==View.VISIBLE){
            CreationQuestionActivity.question5 = q5.getText().toString();
            if(g5.getCheckedRadioButtonId()==R.id.creation_question_format_q5_img){
                q5i1.buildDrawingCache();
                CreationQuestionActivity.q5image1 = q5i1.getDrawingCache().copy(q5i1.getDrawingCache().getConfig(), true);
                q5i2.buildDrawingCache();
                CreationQuestionActivity.q5image2 = q5i2.getDrawingCache().copy(q5i2.getDrawingCache().getConfig(), true);
                q5i3.buildDrawingCache();
                CreationQuestionActivity.q5image3 = q5i3.getDrawingCache().copy(q5i3.getDrawingCache().getConfig(), true);
                q5i4.buildDrawingCache();
                CreationQuestionActivity.q5image4 = q5i4.getDrawingCache().copy(q5i4.getDrawingCache().getConfig(), true);
            }else{
                CreationQuestionActivity.q5texte1 = q5r1.getText().toString();
                CreationQuestionActivity.q5texte2 = q5r2.getText().toString();
                CreationQuestionActivity.q5texte3 = q5r3.getText().toString();
                CreationQuestionActivity.q5texte4 = q5r4.getText().toString();
            }
        }

    }

}