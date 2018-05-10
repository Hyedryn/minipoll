package be.lsinf1225.g16.mini_poll.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementFillChoice;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementFriendsList;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementPreview;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementSend;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationChoiceFillChoice;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationChoiceFriend;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFriendsList;
import be.lsinf1225.g16.mini_poll.model.Participant;
import be.lsinf1225.g16.mini_poll.model.Question;
import be.lsinf1225.g16.mini_poll.model.Reponse;
import be.lsinf1225.g16.mini_poll.model.Sondage;

import static be.lsinf1225.g16.mini_poll.activity.MenuSurveyCreationActivity.creationmenu;

public class CreationAgreementActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 4;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    public static Activity creationagreement;

    public static Bitmap image1;
    public static Bitmap image2;
    public static Bitmap image3;
    public static Bitmap image4;
    public static Bitmap image5;
    public static Bitmap image6;

    public static String question;
    public static String texte1;
    public static String texte2;
    public static String texte3;
    public static String texte4;
    public static String texte5;
    public static String texte6;

    //dots
    private Button btnSkip, btnNext;
    private LinearLayout dotsLayout;
    private TextView[] dots;

    CreationAgreementFillChoice fillchoice;
    CreationAgreementPreview preview;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_agreement);
        creationagreement = this;
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);



        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                // Check if this is the page you want.

                if(position==2){
                    saveReponse();
                }

                System.out.println("Position +"+position);
                addBottomDots(position);

                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == mPagerAdapter.getCount()-1) {
                    // last page. make button text to GOT IT
                    btnNext.setText("TERMINÉ");
                    btnSkip.setVisibility(View.VISIBLE);
                } else {
                    // still pages are left "getString(R.string.next)"
                    btnNext.setText("SUIVANT");
                    btnSkip.setVisibility(View.VISIBLE);
                }

            }
        });


        //dots
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnSkip = (Button) findViewById(R.id.btn_skip);

        // adding bottom dots
        addBottomDots(0);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHomeScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = mPager.getCurrentItem()+1;
                System.out.println("Current page:"+current);
                if (current < NUM_PAGES) {
                    // move to next screen
                    mPager.setCurrentItem(current);


                } else {
                    saveAndLaunchHomeScreen();
                }
            }
        });
    }

    public void saveReponse(){
        fillchoice.save();
        preview.settxt();
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }




    private void addBottomDots(int currentPage) {
        dots = new TextView[NUM_PAGES];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CreationAgreementFillChoice.RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            CreationAgreementFillChoice.imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }

    private void saveAndLaunchHomeScreen(){

        if(CreationAgreementFriendsList.selectedfriends.size()<1){
            MiniPollApp.notifyShort(R.string.error_no_friend_selected);
            return;
        }

        if((texte1==null&&image1==null)||(texte2==null&&image2==null)){
            MiniPollApp.notifyShort(R.string.error_no_2_reponse);
            return;
        }

        if(question==null||question.length()<1){
            MiniPollApp.notifyShort(R.string.error_question_empty);
            return;
        }


        ArrayList<Reponse> r = new ArrayList<Reponse>();
        if(texte1!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.TEXTE, texte1));
        }else if(image1!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.IMAGE, image1));
        }
        if(texte2!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.TEXTE, texte2));
        }else if(image2!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.IMAGE, image2));
        }
        if(texte3!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.TEXTE, texte3));
        }else if(image3!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.IMAGE, image3));
        }
        if(texte4!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.TEXTE, texte4));
        }else if(image4!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.IMAGE, image4));
        }
        if(texte5!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.TEXTE, texte5));
        }else if(image5!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.IMAGE, image5));
        }
        if(texte6!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.TEXTE, texte6));
        }else if(image6!=null){
            r.add(new Reponse(++MiniPollApp.id_Main, Reponse.Categorie.BONNE, Reponse.Format.IMAGE, image6));
        }

        ArrayList<Question> q = new ArrayList<Question>();
        q.add(new Question(question,r.size(),r,++MiniPollApp.id_Main));

        ArrayList<Participant> p = new ArrayList<Participant>();
        for(String s : CreationAgreementFriendsList.selectedfriends){
            p.add(new Participant(MiniPollApp.connectedUser.getAmi(s),Participant.Status.EN_ATTENTE));
        }
        p.add(new Participant(MiniPollApp.connectedUser,Participant.Status.A_REPONDU));

        Sondage s = new Sondage(MiniPollApp.connectedUser,p,++MiniPollApp.id_Main,q,Sondage.Type.SONDAGE_POUR_ACCORD);

        MiniPollApp.connectedUser.addSondage(s);
        MiniPollApp.insertSondage(s,p,q);

        launchHomeScreen();
    }

    private void launchHomeScreen() {
        //   startActivity(new Intent(CreationChoiceActivity.this, MenuMainActivity.class));

        if(creationmenu!=null)
            creationmenu.finish();
        finish();
    }



    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new CreationAgreementFriendsList();
                case 1:
                    return fillchoice = new CreationAgreementFillChoice();
                case 2:
                    return preview = new CreationAgreementPreview();
                case 3:
                    return new CreationAgreementSend();
                default:
                    // This should never happen. Always account for each position above
                    return null;
            }
        }



        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}