package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationAgreementActivity;

public class CreationAgreementPreview extends Fragment {

    public TextView question;

    public TextView r1;
    public TextView r2;
    public TextView r3;
    public TextView r4;
    public TextView r5;
    public TextView r6;

    public ImageView i1;
    public ImageView i2;
    public ImageView i3;
    public ImageView i4;
    public ImageView i5;
    public ImageView i6;

    public View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.creation_agreement_preview, container, false);

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        question = (TextView) view.findViewById(R.id.creation_agreement_preview_question);

        i1 = (ImageView) view.findViewById(R.id.creation_agreement_preview_r1_img);
        i2 = (ImageView) view.findViewById(R.id.creation_agreement_preview_r2_img);
        i3 = (ImageView) view.findViewById(R.id.creation_agreement_preview_r3_img);
        i4 = (ImageView) view.findViewById(R.id.creation_agreement_preview_r4_img);
        i5 = (ImageView) view.findViewById(R.id.creation_agreement_preview_r5_img);
        i6 = (ImageView) view.findViewById(R.id.creation_agreement_preview_r6_img);

        r1 = (TextView) view.findViewById(R.id.creation_agreement_preview_r1_txt);
        r2 = (TextView) view.findViewById(R.id.creation_agreement_preview_r2_txt);
        r3 = (TextView) view.findViewById(R.id.creation_agreement_preview_r3_txt);
        r4 = (TextView) view.findViewById(R.id.creation_agreement_preview_r4_txt);
        r5 = (TextView) view.findViewById(R.id.creation_agreement_preview_r5_txt);
        r6 = (TextView) view.findViewById(R.id.creation_agreement_preview_r6_txt);

    }
    public void settxt(){

        question.setText(CreationAgreementActivity.question);

        if(CreationAgreementActivity.texte1!=null){
            r1.setText(CreationAgreementActivity.texte1);
            r1.setVisibility(View.VISIBLE);
        }else{
            r1.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.texte2!=null){
            r2.setText(CreationAgreementActivity.texte2);
            r2.setVisibility(View.VISIBLE);
        }else{
            r2.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.texte3!=null){
            r3.setText(CreationAgreementActivity.texte3);
            r3.setVisibility(View.VISIBLE);
        }else{
            r3.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.texte4!=null){
            r4.setText(CreationAgreementActivity.texte4);
            r4.setVisibility(View.VISIBLE);
        }else{
            r4.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.texte5!=null){
            r5.setText(CreationAgreementActivity.texte5);
            r5.setVisibility(View.VISIBLE);
        }else{
            r5.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.texte6!=null){
            r6.setText(CreationAgreementActivity.texte6);
            r6.setVisibility(View.VISIBLE);
        }else{
            r6.setVisibility(View.GONE);
        }

        if(CreationAgreementActivity.image1!=null){
            i1.setImageBitmap(CreationAgreementActivity.image1);
            i1.setVisibility(View.VISIBLE);
        }else{
            i1.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.image2!=null){
            i2.setImageBitmap(CreationAgreementActivity.image2);
            i2.setVisibility(View.VISIBLE);
        }else{
            i2.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.image3!=null){
            i3.setImageBitmap(CreationAgreementActivity.image3);
            i3.setVisibility(View.VISIBLE);
        }else{
            i3.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.image4!=null){
            i4.setImageBitmap(CreationAgreementActivity.image4);
            i4.setVisibility(View.VISIBLE);
        }else{
            i4.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.image5!=null){
            i5.setImageBitmap(CreationAgreementActivity.image5);
            i5.setVisibility(View.VISIBLE);
        }else{
            i5.setVisibility(View.GONE);
        }
        if(CreationAgreementActivity.image6!=null){
            i6.setImageBitmap(CreationAgreementActivity.image6);
            i6.setVisibility(View.VISIBLE);
        }else{
            i6.setVisibility(View.GONE);
        }

    }
}