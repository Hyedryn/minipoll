package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationAgreementActivity;
import be.lsinf1225.g16.mini_poll.activity.CreationChoiceActivity;

public class CreationAgreementFillChoice extends Fragment {

    public View view;


    boolean alreadyinit = false;

    public static LinearLayout linearLayout;

    public EditText question;

    public EditText r1;
    public EditText r2;
    public EditText r3;
    public EditText r4;
    public EditText r5;
    public EditText r6;

    public ImageView i1;
    public ImageView i2;
    public ImageView i3;
    public ImageView i4;
    public ImageView i5;
    public ImageView i6;

    public Button addImg;
    public Button addTxt;
    public Button remove;

    private int lastIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_agreement_fill_choice, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout = (LinearLayout) view.findViewById(R.id.creation_agreement_fill_placeholder);
        this.view = view;
        addTxt = (Button) view.findViewById(R.id.creation_agreement_fill_add_rep_txt);
        addImg = (Button) view.findViewById(R.id.creation_agreement_fill_add_rep_img);
        remove = (Button) view.findViewById(R.id.creation_agreement_fill_remove_rep);

        question = (EditText) view.findViewById(R.id.creation_agreement_fill_question);

        i1 = (ImageView) view.findViewById(R.id.creation_agreement_fill_r1_img);
        i2 = (ImageView) view.findViewById(R.id.creation_agreement_fill_r2_img);
        i3 = (ImageView) view.findViewById(R.id.creation_agreement_fill_r3_img);
        i4 = (ImageView) view.findViewById(R.id.creation_agreement_fill_r4_img);
        i5 = (ImageView) view.findViewById(R.id.creation_agreement_fill_r5_img);
        i6 = (ImageView) view.findViewById(R.id.creation_agreement_fill_r6_img);

        r1 = (EditText) view.findViewById(R.id.creation_agreement_fill_r1_txt);
        r2 = (EditText) view.findViewById(R.id.creation_agreement_fill_r2_txt);
        r3 = (EditText) view.findViewById(R.id.creation_agreement_fill_r3_txt);
        r4 = (EditText) view.findViewById(R.id.creation_agreement_fill_r4_txt);
        r5 = (EditText) view.findViewById(R.id.creation_agreement_fill_r5_txt);
        r6 = (EditText) view.findViewById(R.id.creation_agreement_fill_r6_txt);

        addImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (lastIndex){
                    case 0:
                        i1.setVisibility(View.VISIBLE);
                        remove.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 1:
                        i2.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 2:
                        i3.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 3:
                        i4.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 4:
                        i5.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 5:
                        i6.setVisibility(View.VISIBLE);
                        addImg.setVisibility(View.GONE);
                        addTxt.setVisibility(View.GONE);
                        lastIndex++;
                        break;
                }
            }
        });


        addTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (lastIndex){
                    case 0:
                        r1.setVisibility(View.VISIBLE);
                        remove.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 1:
                        r2.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 2:
                        r3.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 3:
                        r4.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 4:
                        r5.setVisibility(View.VISIBLE);
                        lastIndex++;
                        break;
                    case 5:
                        r6.setVisibility(View.VISIBLE);
                        addImg.setVisibility(View.GONE);
                        addTxt.setVisibility(View.GONE);
                        lastIndex++;
                        break;
                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("LastIndex: "+lastIndex);
                switch (lastIndex){
                    case 1:
                        r1.setVisibility(View.GONE);
                        i1.setVisibility(View.GONE);
                        remove.setVisibility(View.GONE);
                        lastIndex--;
                        break;
                    case 2:
                        r2.setVisibility(View.GONE);
                        i2.setVisibility(View.GONE);
                        lastIndex--;
                        break;
                    case 3:
                        r3.setVisibility(View.GONE);
                        i3.setVisibility(View.GONE);
                        lastIndex--;
                        break;
                    case 4:
                        r4.setVisibility(View.GONE);
                        i4.setVisibility(View.GONE);
                        lastIndex--;
                        break;
                    case 5:
                        r5.setVisibility(View.GONE);
                        i5.setVisibility(View.GONE);
                        lastIndex--;
                        break;
                    case 6:
                        r6.setVisibility(View.GONE);
                        i6.setVisibility(View.GONE);
                        addImg.setVisibility(View.VISIBLE);
                        addTxt.setVisibility(View.VISIBLE);
                        lastIndex--;
                        break;
                }
            }
        });



    }


    public void save(){

        CreationAgreementActivity.question = question.getText().toString();

        if(r1.getVisibility()==View.VISIBLE){
            CreationAgreementActivity.texte1 = r1.getText().toString();
        }else{
            r1.setText("");
            CreationAgreementActivity.texte1 = null;
        }
        if(r2.getVisibility()==View.VISIBLE){
            CreationAgreementActivity.texte2 = r2.getText().toString();
        }else{
            r2.setText("");
            CreationAgreementActivity.texte2 = null;
        }
        if(r3.getVisibility()==View.VISIBLE){
            CreationAgreementActivity.texte3 = r3.getText().toString();
        }else{
            r3.setText("");
            CreationAgreementActivity.texte3 = null;
        }
        if(r4.getVisibility()==View.VISIBLE){
            CreationAgreementActivity.texte4 = r4.getText().toString();
        }else{
            r4.setText("");
            CreationAgreementActivity.texte4 = null;
        }
        if(r5.getVisibility()==View.VISIBLE){
            CreationAgreementActivity.texte5 = r5.getText().toString();
        }else{
            r5.setText("");
            CreationAgreementActivity.texte5 = null;
        }
        if(r6.getVisibility()==View.VISIBLE){
            CreationAgreementActivity.texte6 = r6.getText().toString();
        }else{
            r6.setText("");
            CreationAgreementActivity.texte6 = null;
        }


        if(i1.getVisibility()==View.VISIBLE){
            i1.buildDrawingCache();
            CreationAgreementActivity.image1 = i1.getDrawingCache().copy(i1.getDrawingCache().getConfig(), true);
        }else{
            i1.setImageResource(R.drawable.edit_pen);
            CreationAgreementActivity.image1 = null;
        }
        if(i2.getVisibility()==View.VISIBLE){
            i2.buildDrawingCache();
            CreationAgreementActivity.image2 = i2.getDrawingCache().copy(i2.getDrawingCache().getConfig(), true);
        }else{
            i2.setImageResource(R.drawable.edit_pen);
            CreationAgreementActivity.image2 = null;
        }
        if(i3.getVisibility()==View.VISIBLE){
            i3.buildDrawingCache();
            CreationAgreementActivity.image3 = i3.getDrawingCache().copy(i3.getDrawingCache().getConfig(), true);
        }else{
            i3.setImageResource(R.drawable.edit_pen);
            CreationAgreementActivity.image3 = null;
        }
        if(i4.getVisibility()==View.VISIBLE){
            i4.buildDrawingCache();
            CreationAgreementActivity.image4 = i4.getDrawingCache().copy(i4.getDrawingCache().getConfig(), true);
        }else{
            i4.setImageResource(R.drawable.edit_pen);
            CreationAgreementActivity.image4 = null;
        }
        if(i5.getVisibility()==View.VISIBLE){
            i5.buildDrawingCache();
            CreationAgreementActivity.image5 = i5.getDrawingCache().copy(i5.getDrawingCache().getConfig(), true);
        }else{
            i5.setImageResource(R.drawable.edit_pen);
            CreationAgreementActivity.image5 = null;
        }
        if(i6.getVisibility()==View.VISIBLE){
            i6.buildDrawingCache();
            CreationAgreementActivity.image6 = i6.getDrawingCache().copy(i6.getDrawingCache().getConfig(), true);
        }else{
            i6.setImageResource(R.drawable.edit_pen);
            CreationAgreementActivity.image6 = null;
        }

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&!alreadyinit) {

            alreadyinit = true;



        }
    }

}