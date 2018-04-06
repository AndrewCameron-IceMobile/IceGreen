package com.icemobile.icegreen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardActivity extends AppCompatActivity {

    private static final String LEADERBOARD_FRAGMENT_TAG = "LEADERBOARD_FRAGMENT_TAG";
    public static final String ARG_EXTRA_BUNDLE = "ARG_EXTRA_BUNDLE";

    //Previous Variables
//    private List<LeaderboardProfile> mLeaderboardProfileList = new ArrayList<>();
//    private RecyclerView mRecyclerView;
//    private LeaderboardAdapter mAdapter;

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
