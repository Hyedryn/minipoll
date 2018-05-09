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
                   for(int j=1;j<=2;j++){
                       CardView c = new CardView(getActivity());
                       LinearLayout l = new LinearLayout(getActivity());
                       EditText t = new EditText(getActivity());
                       if(j==1)
                           r1=t;
                       else
                           r2=t;
                       //     ImageView i = new ImageView(getActivity());

                       CardView.LayoutParams paramsL = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);

                       LinearLayout.LayoutParams paramsC = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

                       paramsC.setMargins(5, 5, 5, 5);

                       LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);

                       //    LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

                       c.setMaxCardElevation(5);
                       c.setCardElevation(2.0f);
                       c.setRadius(2.0f);
                       c.setCardBackgroundColor(getResources().getColor(R.color.dot_dark_screen3));
                       c.setLayoutParams(paramsC);

                       l.setOrientation(LinearLayout.HORIZONTAL);
                       l.setLayoutParams(paramsL);


                       t.setGravity(Gravity.CENTER);
                       t.setTextColor(Color.WHITE);
                       t.setTextSize(18f);
                       t.setHint("Réponse " + j);


                       t.setTypeface(Typeface.DEFAULT_BOLD);
                       t.setLayoutParams(paramsT);

                       //    i.setLayoutParams(paramsI);
                       //    i.setImageResource(android.R.drawable.ic_delete);
                       //    i.setBackgroundColor(getResources().getColor(R.color.backgroundqcrea1));
                       //    i.setColorFilter(getResources().getColor(R.color.tint1));

                       l.addView(t);
                       //    l.addView(i);
                       c.addView(l);


                       linearLayout.addView(c);

                   }
               }else {

                   for(int j=1;j<=2;j++){
                   CardView c = new CardView(getActivity());
                   LinearLayout l = new LinearLayout(getActivity());
                   EditText t = new EditText(getActivity());
                   if(j==1)
                       r1=t;
                   else
                       r2=t;
              //     ImageView i = new ImageView(getActivity());

                   CardView.LayoutParams paramsL = new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT);

                   LinearLayout.LayoutParams paramsC = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

                   paramsC.setMargins(5, 5, 5, 5);

                   LinearLayout.LayoutParams paramsT = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);

               //    LinearLayout.LayoutParams paramsI = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);

                   c.setMaxCardElevation(5);
                   c.setCardElevation(2.0f);
                   c.setRadius(2.0f);
                   c.setCardBackgroundColor(getResources().getColor(R.color.dot_dark_screen3));
                   c.setLayoutParams(paramsC);

                   l.setOrientation(LinearLayout.HORIZONTAL);
                   l.setLayoutParams(paramsL);


                   t.setGravity(Gravity.CENTER);
                   t.setTextColor(Color.WHITE);
                   t.setTextSize(18f);
                   t.setHint("Réponse " + j);


                   t.setTypeface(Typeface.DEFAULT_BOLD);
                   t.setLayoutParams(paramsT);

               //    i.setLayoutParams(paramsI);
               //    i.setImageResource(android.R.drawable.ic_delete);
               //    i.setBackgroundColor(getResources().getColor(R.color.backgroundqcrea1));
               //    i.setColorFilter(getResources().getColor(R.color.tint1));

                   l.addView(t);
               //    l.addView(i);
                   c.addView(l);


                   linearLayout.addView(c);

                   }
               }
        }
    }

public void save(){
    if(format.equalsIgnoreCase("Image")){
        ImageView imageView1 = (ImageView)  i1;
        ImageView imageView2 = (ImageView)  i2;

        CreationChoiceActivity.image1 = imageView1.getDrawingCache().copy(imageView1.getDrawingCache().getConfig(), true);
        CreationChoiceActivity.image2 = imageView2.getDrawingCache().copy(imageView2.getDrawingCache().getConfig(), true);

    }else{

        CreationChoiceActivity.texte1 = r1.getText().toString();
        CreationChoiceActivity.texte2 = r2.getText().toString();
    }
}

}