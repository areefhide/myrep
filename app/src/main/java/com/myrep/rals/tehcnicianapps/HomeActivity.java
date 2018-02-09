package com.myrep.rals.tehcnicianapps;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.WindowManager;

import com.myrep.rals.tehcnicianapps.Utility.CustomTypefaceSpan;
import com.myrep.rals.tehcnicianapps.Utility.FragmentTab;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private Context ctx;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        setActionbarTextColor(mActionBar);
        ctx = this;

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.bottomNavigation);
        viewPager.setOffscreenPageLimit(4);
        setupViewPager();

        tabLayout.setupWithViewPager(viewPager);
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabLayout.getTabAt(0).setIcon(R.drawable.home_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.history_icon);
//        tabLayout.getTabAt(2).setIcon(R.drawable.star_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.profile_icon);

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#4B7FD1"), PorterDuff.Mode.SRC_IN);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#4B7FD1"), PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager() {
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        Fragment fragHome = new HomeFragment();
        Fragment fragHistory = new HistoryFragment();
//        Fragment fragRatings = new RatingsFragment();
        Fragment fragProfile = new ProfileFragment();


        adapter.addFragment(fragHome, "Home");
        adapter.addFragment(fragHistory, "History");
//        adapter.addFragment(fragRatings, "Ratings");
        adapter.addFragment(fragProfile, "Profile");
        viewPager.setAdapter(adapter);
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> listFragment = new ArrayList<>();
        private final List<String> listFragmentTitle = new ArrayList<>();

        MyFragmentPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

        void addFragment(Fragment fragment, String title) {
            listFragment.add(fragment);
            listFragmentTitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listFragmentTitle.get(position);
        }
    }

    private void setActionbarTextColor(ActionBar actBar) {


        SpannableStringBuilder SS = new SpannableStringBuilder("Technician");


        Typeface robotoRegular = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.otf");

        TypefaceSpan robotoRegularSpan = new CustomTypefaceSpan("", robotoRegular);
        SS.setSpan(robotoRegularSpan, 0, SS.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        SS.setSpan(new ForegroundColorSpan(Color.WHITE), 0, SS.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        actBar.setTitle(SS);
    }


}