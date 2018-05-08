package be.lsinf1225.g16.mini_poll.activity.creationFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.CreationChoiceActivity;

public class CreationChoiceFillChoice extends Fragment {

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


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            int radioButtonID = CreationChoiceFormat.radioButtonGroup.getCheckedRadioButtonId();
             if(radioButtonID==-1){
               MiniPollApp.notifyLong(R.string.error_no_format_selected);
               CreationChoiceActivity.creationchoice.finish();
                 return;
              }
               View radioButton = CreationChoiceFormat.radioButtonGroup.findViewById(radioButtonID);
               int idx = CreationChoiceFormat.radioButtonGroup.indexOfChild(radioButton);
               RadioButton btn = (RadioButton) CreationChoiceFormat.radioButtonGroup.getChildAt(idx);
               String format = (String) btn.getText();

               if(format.equalsIgnoreCase("Image")){

               }else{

               }
        }
        else {
        }
    }


}