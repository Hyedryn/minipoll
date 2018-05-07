package be.lsinf1225.g16.mini_poll.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementFillChoice;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementFriendsList;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementPreview;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementSend;
import be.lsinf1225.g16.mini_poll.activity.replyFragment.ReplyAgreementFillAnswer;
import be.lsinf1225.g16.mini_poll.activity.replyFragment.ReplyAgreementSummary;
import be.lsinf1225.g16.mini_poll.model.Participant;
import be.lsinf1225.g16.mini_poll.model.Sondage;
import be.lsinf1225.g16.mini_poll.model.SondagePourAccord;

import static be.lsinf1225.g16.mini_poll.activity.MenuSurveyCreationActivity.creationmenu;

public class ReplyAgreementActivity  extends FragmentActivity {


    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private final static int NUM_PAGES = 2;


    private int active_page = 2;

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

    public Sondage sondage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_agreement);


        Intent intent = getIntent();
        int sondageID = intent.getIntExtra("sondageID",0);
        this.sondage = (Sondage) MiniPollApp.connectedUser.getSondage(sondageID);

        //dots
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnSkip = (Button) findViewById(R.id.btn_skip);

        if(sondage==null)
            finish();


        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new ReplyAgreementActivity.ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        if(sondage.getState().equals(Sondage.Etat.CLOTURE)||(sondage.getParticipant(MiniPollApp.connectedUser)!=null&&sondage.getParticipant(MiniPollApp.connectedUser).getStatus().equals(Participant.Status.A_REPONDU))){

            active_page=1;
            btnSkip.setVisibility(View.INVISIBLE);
            btnNext.setVisibility(View.INVISIBLE);
            dotsLayout.setVisibility(View.INVISIBLE);

        }else{



            mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int state) {}
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

                public void onPageSelected(int position) {
                    // Check if this is the page you want.


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
                if (current < active_page) {
                    // move to next screen
                    mPager.setCurrentItem(current);


                } else {
                    launchHomeScreen();
                }
                }
            });

        }


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
        dots = new TextView[active_page];

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




    private void launchHomeScreen() {
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

            if(active_page==1){
                return new ReplyAgreementSummary();
            }else {

                switch (position) {
                    case 0:
                        return new ReplyAgreementFillAnswer();
                    case 1:
                        return new ReplyAgreementSummary();
                    default:
                        // This should never happen. Always account for each position above
                        return null;
                }
            }

        }



        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
