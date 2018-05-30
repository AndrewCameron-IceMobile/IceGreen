package com.icemobile.icegreen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LeaderboardActivity extends AppCompatActivity {

    private static final String LEADERBOARD_FRAGMENT_TAG = "LEADERBOARD_FRAGMENT_TAG";
    public static final String ARG_EXTRA_BUNDLE = "ARG_EXTRA_BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);
        setContentView(R.layout.activity_leaderboard);

        if (savedInstanceState == null && !isFragmentShown()){
            showFragment();
        }
    }

    private void showFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        LeaderboardFragment fragment = LeaderboardFragment.newInstance(getIntent().getBundleExtra(ARG_EXTRA_BUNDLE));

        ft.replace(R.id.fragment_container, fragment, LEADERBOARD_FRAGMENT_TAG);
        ft.commit();
    }

    private boolean isFragmentShown(){
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentByTag(LEADERBOARD_FRAGMENT_TAG);

        return fragment != null;
    }

}