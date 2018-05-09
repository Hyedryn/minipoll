package be.lsinf1225.g16.mini_poll.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementFriendsList;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationChoiceFillChoice;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationChoiceFormat;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationChoiceFriend;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationChoicePreview;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationChoiceSend;
import be.lsinf1225.g16.mini_poll.model.Participant;
import be.lsinf1225.g16.mini_poll.model.Question;
import be.lsinf1225.g16.mini_poll.model.Reponse;
import be.lsinf1225.g16.mini_poll.model.Sondage;

import static be.lsinf1225.g16.mini_poll.activity.MenuSurveyCreationActivity.creationmenu;

public class CreationChoiceActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    CreationChoiceFillChoice fillchoice;
    CreationChoicePreview preview;

    public static Activity creationchoice;

    public static Bitmap image1;
    public static Bitmap image2;

    public static String question;
    public static String texte1;
    public static String texte2;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;


    //dots
    private Button btnSkip, btnNext;
    private LinearLayout dotsLayout;
    private TextView[] dots;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_choice);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(2);

        creationchoice =this;

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                // Check if this is the page you want.

                if(position==3){
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

        question = ((TextView) findViewById(R.id.question)).getText().toString();

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


    private void saveAndLaunchHomeScreen(){
        RadioGroup radioButtonGroup = CreationChoiceFriend.radioGroup;
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        if(radioButtonID==-1){
            MiniPollApp.notifyShort(R.string.error_no_friend_selected);
            return;
        }
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) radioButtonGroup.getChildAt(idx);
        String identifiant = (String) btn.getText();

        Reponse r1;
        Reponse r2;


        if(CreationChoiceFillChoice.format.equalsIgnoreCase("image")) {
            r1 = new Reponse(1, Reponse.Categorie.BONNE, Reponse.Format.IMAGE, image1);
            r2 = new Reponse(2, Reponse.Categorie.BONNE, Reponse.Format.IMAGE, image2);
        }else{
            r1 = new Reponse(1, Reponse.Categorie.BONNE, Reponse.Format.TEXTE, texte1);
            r2 = new Reponse(2, Reponse.Categorie.BONNE, Reponse.Format.TEXTE, texte2);
        }
        ArrayList<Reponse> r = new ArrayList<Reponse>();
        r.add(r1);
        r.add(r2);
        Question q1 = new Question(question,2,r,1);
        Participant p1 = new Participant(MiniPollApp.connectedUser.getAmi(identifiant),Participant.Status.EN_ATTENTE);
        ArrayList<Participant> p = new ArrayList<Participant>();
        p.add(p1);
        ArrayList<Question> q = new ArrayList<Question>();
        q.add(q1);
        Sondage s = new Sondage(MiniPollApp.connectedUser,p,0,q,Sondage.Type.AIDER_UN_AMI);



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
                    return new CreationChoiceFriend();
                case 1:
                    return new CreationChoiceFormat();
                case 2:

                    return fillchoice = new CreationChoiceFillChoice();
                case 3:
                    return preview = new CreationChoicePreview();
                case 4:
                    return new CreationChoiceSend();
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