package be.lsinf1225.g16.mini_poll.activity;

import android.gesture.GestureOverlayView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.GestureDetector.OnGestureListener;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.model.Utilisateur;

public class FriendsAddActivity extends AppCompatActivity implements OnGestureListener {

    private static ArrayList<Utilisateur> notfriends = new ArrayList<>();

    private Integer i = new Integer(0);

    GestureDetector gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_add);

        gestureDetector = new GestureDetector(FriendsAddActivity.this, FriendsAddActivity.this);

        for(Utilisateur u : MiniPollApp.utilisateurs){
            if(MiniPollApp.connectedUser.getAmi(u.getIdentifiant())==null&&!u.equals(MiniPollApp.connectedUser)){
                notfriends.add(u);
            }
        }

        if(notfriends==null||notfriends.size()<1){
            displayUser(null);
        }else {
            displayUser(notfriends.get(0));
        }
    }

    private void displayUser(Utilisateur u){
        if(u==null){
            ((TextView)findViewById(R.id.add_name_inf)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.add_id_inf)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.add_email_inf)).setVisibility(View.INVISIBLE);
            ((ImageButton)findViewById(R.id.add_ok_btn)).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.add_ajouter_txt)).setText(R.string.error_no_available_friend);
            ((TextView)findViewById(R.id.add_ajouter_txt)).setTextSize(12);
            return;
        }

        ((TextView)findViewById(R.id.add_name_inf)).setText("Nom: "+u.getPrenom()+" "+u.getNom());
        ((TextView)findViewById(R.id.add_email_inf)).setText("Email: "+u.getEmail());
        ((TextView)findViewById(R.id.add_id_inf)).setText("ID: "+u.getIdentifiant());

        if(u.getPhoto()!=null&&u.getPhoto().getConfig()!=null)
            ((ImageView) findViewById(R.id.add_profil_img)).setImageBitmap(u.getPhoto());

    }


    public void add_next(View view) {
        if (notfriends == null || notfriends.size() < 1) {
            displayUser(null);
            return;
        }
        if (i < (notfriends.size() - 1)){
            i++;
        }else{
            if(i>=(notfriends.size()-1))
                i=0;
        }

        displayUser(notfriends.get(i));
    }

    public void add_previous(View view){
        if(notfriends==null||notfriends.size()<1){
            displayUser(null);
            return;
        }

        if(i<=0) {
            i = notfriends.size() - 1;

        }else{
            if(i>=1)
                i--;
        }


        displayUser(notfriends.get(i));
    }

    public void add_ok(View view){
        if(notfriends==null||notfriends.size()<1){
            return;
        }

        notfriends.get(i).addDemandeAmi(MiniPollApp.connectedUser.getIdentifiant());
        notfriends.remove(notfriends.get(i));
        add_next(view);
    }



    @Override
    public void onBackPressed(){
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
            add_next(v);
            return true;
        }

        if(motionEvent2.getX() - motionEvent1.getX() > 70) {
            System.out.println(" Swipe Right ");
            View v=null;
            add_previous(v);
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
