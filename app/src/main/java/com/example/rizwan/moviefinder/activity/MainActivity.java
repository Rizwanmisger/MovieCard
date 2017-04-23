package com.example.rizwan.moviefinder.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rizwan.moviefinder.R;

import com.example.rizwan.moviefinder.fragment.LatestMoviesFragment;
import com.example.rizwan.moviefinder.fragment.LatestTvShowsFragment;
import com.example.rizwan.moviefinder.fragment.MainActivityFragment;
import com.example.rizwan.moviefinder.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity  {
    Activity activity = this;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();*/

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportActionBar().setDisplayShowTitleEnabled(false);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        bottomNavigationView.setActivated(true);
        // bottomNavigationView.getMenu().s;
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        bottomNavigationView.getMenu().getItem(2).setChecked(false);
        bottomNavigationView.getMenu().getItem(1).setChecked(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_tv: {
                                Intent intent = new Intent(activity, TVActivity.class);
                                activity.startActivity(intent);
                                break;
                            }

                            case R.id.action_people: {

                            }
                        }
                        return true;
                    }
                });


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        LatestMoviesFragment lmFragment = new LatestMoviesFragment();

        adapter.addFragment(new LatestMoviesFragment(), "Latest");
        adapter.addFragment(new MainActivityFragment(), "Top Rated");


        viewPager.setAdapter(adapter);

    }


}