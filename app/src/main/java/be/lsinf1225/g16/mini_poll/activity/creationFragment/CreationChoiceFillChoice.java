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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationChoiceActivity;

public class CreationChoiceFillChoice extends Fragment {

    public static LinearLayout linearLayout;

    public View view;

    public static String format;

    public EditText r1;

    public EditText r2;

    public ImageView i1;

    public ImageView i2;

    boolean alreadyinit = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(

                R.layout.creation_choice_fill_choice, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout = (LinearLayout) view.findViewById(R.id.creation_choice_fill_placeholder);
        this.view = view;
        r1 = (EditText) view.findViewById(R.id.creation_choice_fill_r1_txt);
        r2 = (EditText) view.findViewById(R.id.creation_choice_fill_r2_txt);
        i1 = (ImageView) view.findViewById(R.id.creation_choice_fill_r1_img);
        i2 = (ImageView) view.findViewById(R.id.creation_choice_fill_r2_img);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&!alreadyinit) {

            alreadyinit = true;

            int radioButtonID = CreationChoiceFormat.radioButtonGroup.getCheckedRadioButtonId();
             if(radioButtonID==-1){
               MiniPollApp.notifyLong(R.string.error_no_format_selected);
               CreationChoiceActivity.creationchoice.finish();
                 return;
              }
               View radioButton = CreationChoiceFormat.radioButtonGroup.findViewById(radioButtonID);
               int idx = CreationChoiceFormat.radioButtonGroup.indexOfChild(radioButton);
               RadioButton btn = (RadioButton) CreationChoiceFormat.radioButtonGroup.getChildAt(idx);
               format = (String) btn.getText();

               if(format.equalsIgnoreCase("Image")){
                   r1.setVisibility(View.GONE);
                   r2.setVisibility(View.GONE);
                   i1.setVisibility(View.VISIBLE);
                   i2.setVisibility(View.VISIBLE);


               }else {
                    r1.setVisibility(View.VISIBLE);
                    r2.setVisibility(View.VISIBLE);
                    i1.setVisibility(View.GONE);
                    i2.setVisibility(View.GONE);
               }
        }
    }

public void save(){
    if(format.equalsIgnoreCase("Image")){
        ImageView imageView1 = (ImageView)  i1;
        ImageView imageView2 = (ImageView)  i2;

        imageView1.buildDrawingCache();
        imageView2.buildDrawingCache();
        CreationChoiceActivity.image1 = imageView1.getDrawingCache().copy(imageView1.getDrawingCache().getConfig(), true);
        CreationChoiceActivity.image2 = imageView2.getDrawingCache().copy(imageView2.getDrawingCache().getConfig(), true);

    }else{

        CreationChoiceActivity.texte1 = r1.getText().toString();
        CreationChoiceActivity.texte2 = r2.getText().toString();
    }
}

}