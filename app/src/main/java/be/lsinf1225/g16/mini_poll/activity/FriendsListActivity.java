package be.lsinf1225.g16.mini_poll.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class FriendsListActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private Integer i = new Integer(0);

    GestureDetector gestureDetector;

    private ArrayList<Utilisateur> listamis = MiniPollApp.connectedUser.getListAmi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        gestureDetector = new GestureDetector(FriendsListActivity.this, FriendsListActivity.this);


        if(listamis==null||listamis.size()<1){
            displayUser(null);
        }else {
            displayUser(listamis.get(0));
        }
    }

    private void displayUser(Utilisateur u){
        if(u==null){
            ((TextView)findViewById(R.id.list_name)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.list_id)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.list_email)).setVisibility(View.INVISIBLE);
            ((ImageButton)findViewById(R.id.list_crown_btn)).setVisibility(View.INVISIBLE);
            ((ImageButton)findViewById(R.id.list_delete_btn)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.list_ami_banner)).setText(R.string.error_no_available_friend);
            ((TextView)findViewById(R.id.list_ami_banner)).setTextSize(12);
            return;
        }

        if(u.getIdentifiant().equals(MiniPollApp.connectedUser.getMeilleurAmi())) {
            ((ImageButton)findViewById(R.id.list_crown_btn)).setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

        }else{
            ((ImageButton) findViewById(R.id.list_crown_btn)).setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        }

        ((TextView)findViewById(R.id.list_name)).setText("Nom: "+u.getPrenom()+" "+u.getNom());
        ((TextView)findViewById(R.id.list_email)).setText("Email: "+u.getEmail());
        ((TextView)findViewById(R.id.list_id)).setText("ID: "+u.getIdentifiant());

        if(u.getPhoto()!=null&&u.getPhoto().getConfig()!=null)
            ((ImageView) findViewById(R.id.list_profile_picture)).setImageBitmap(u.getPhoto());

    }


    public void list_next(View view) {
        if (listamis == null || listamis.size() < 1) {
            displayUser(null);
            return;
        }
        if (i < (listamis.size() - 1)){
            i++;
        }else{
            if(i>=(listamis.size()-1))
                i=0;
        }

        displayUser(listamis.get(i));
    }

    public void list_previous(View view){
        if(listamis==null||listamis.size()<1){
            displayUser(null);
            return;
        }

        if(i<=0) {
            i = listamis.size() - 1;

        }else{
            if(i>=1)
                i--;
        }


        displayUser(listamis.get(i));
    }

    public void list_crown(View view){
        if(listamis==null||listamis.size()<1){
            return;
        }
        if(MiniPollApp.connectedUser.getMeilleurAmi().equals(listamis.get(i).getIdentifiant())){
            MiniPollApp.connectedUser.setMeilleurAmi("");
            ((ImageButton)findViewById(R.id.list_crown_btn)).setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        }else{
            MiniPollApp.connectedUser.setMeilleurAmi(listamis.get(i).getIdentifiant());
            ((ImageButton)findViewById(R.id.list_crown_btn)).setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
    }

    public void list_delete(View view){
        if(listamis==null||listamis.size()<1){
            return;
        }

        MiniPollApp.connectedUser.removeAmi(listamis.get(i).getIdentifiant());
        list_next(view);
    }


    @Override
    public void onBackPressed(){
        MiniPollApp.saveUser(MiniPollApp.connectedUser);
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {

        if(motionEvent1.getY() - motionEvent2.getY() > 150){
            System.out.println(" Swipe UP ");


            //  return true;
        }

        if(motionEvent2.getY() - motionEvent1.getY() > 150){
            System.out.println(" Swipe Down ");

            // return true;
        }

        if(motionEvent1.getX() - motionEvent2.getX() > 70){
            System.out.println(" Swipe Left ");
            View v=null;
            list_next(v);
            return true;
        }

        if(motionEvent2.getX() - motionEvent1.getX() > 70) {
            System.out.println(" Swipe Right ");
            View v=null;
            list_previous(v);
            return true;
        }
        else {

            return true ;
        }
    }

    @Override
    public void onLongPress(MotionEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {

        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {

        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        // TODO Auto-generated method stub

        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {

        // TODO Auto-generated method stub

        return false;
    }
}
