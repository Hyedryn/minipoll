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
import android.widget.TextView;

import be.lsinf1225.g16.mini_poll.MiniPollApp;
import be.lsinf1225.g16.mini_poll.R;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationAgreementFriendsList;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionEditOrder;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFillChoice;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFormat;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionFriendsList;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionPreview;
import be.lsinf1225.g16.mini_poll.activity.creationFragment.CreationQuestionSend;

import static be.lsinf1225.g16.mini_poll.activity.MenuSurveyCreationActivity.creationmenu;

public class CreationQuestionActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 6;


    public static Bitmap q1image1;
    public static Bitmap q1image2;
    public static Bitmap q1image3;
    public static Bitmap q1image4;

    public static String question1;
    public static String q1texte1;
    public static String q1texte2;
    public static String q1texte3;
    public static String q1texte4;

    public static Bitmap q2image1;
    public static Bitmap q2image2;
    public static Bitmap q2image3;
    public static Bitmap q2image4;

    public static String question2;
    public static String q2texte1;
    public static String q2texte2;
    public static String q2texte3;
    public static String q2texte4;

    public static Bitmap q3image1;
    public static Bitmap q3image2;
    public static Bitmap q3image3;
    public static Bitmap q3image4;

    public static String question3;
    public static String q3texte1;
    public static String q3texte2;
    public static String q3texte3;
    public static String q3texte4;

    public static Bitmap q4image1;
    public static Bitmap q4image2;
    public static Bitmap q4image3;
    public static Bitmap q4image4;

    public static String question4;
    public static String q4texte1;
    public static String q4texte2;
    public static String q4texte3;
    public static String q4texte4;

    public static Bitmap q5image1;
    public static Bitmap q5image2;
    public static Bitmap q5image3;
    public static Bitmap q5image4;

    public static String question5;
    public static String q5texte1;
    public static String q5texte2;
    public static String q5texte3;
    public static String q5texte4;

    CreationQuestionFillChoice fillchoice;
    CreationQuestionPreview preview;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    public static Activity creationquestion;

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
        setContentView(R.layout.activity_creation_question);
        creationquestion = this;
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);



        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                // Check if this is the page you want.

                System.out.println("Position +"+position);
                addBottomDots(position);

                if(position==2){
                    saveReponse();
                }

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

    public void saveReponse(){
        fillchoice.save();
        preview.settxt();
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

        if (requestCode == CreationQuestionFillChoice.RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            CreationQuestionFillChoice.imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }


    private void saveAndLaunchHomeScreen(){

        if(CreationQuestionFriendsList.selectedfriends.size()<1){
            MiniPollApp.notifyShort(R.string.error_no_friend_selected);
            return;
        }

        for(String s : CreationQuestionFriendsList.selectedfriends){
            System.out.println("Ami select: "+s);
        }

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
                    return new CreationQuestionFriendsList();
                case 1:
                    return new CreationQuestionFormat();
                case 2:
                    return fillchoice = new CreationQuestionFillChoice();
                case 3:
                    return preview = new CreationQuestionPreview();
                case 4:
                    return new CreationQuestionEditOrder();
                case 5:
                    return new CreationQuestionSend();
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