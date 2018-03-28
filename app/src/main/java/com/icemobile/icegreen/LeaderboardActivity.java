package com.icemobile.icegreen;

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
    private List<LeaderboardProfile> mLeaderboardProfileList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private LeaderboardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new LeaderboardAdapter(mLeaderboardProfileList);

        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setAdapter(mAdapter);

//        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                LeaderboardProfile leaderboardProfile = mLeaderboardProfileList.get(position);
//                Toast.makeText(getApplicationContext(), leaderboardProfile.getUsername() + get)
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));
        prepareLeaderboardProfileData();
    }

    private void prepareLeaderboardProfileData() {
        LeaderboardProfile leaderboardProfile = new LeaderboardProfile("Test Name", "32", "1");
        mLeaderboardProfileList.add(leaderboardProfile);

        leaderboardProfile = new LeaderboardProfile("Jonny B", "12", "2");
        mLeaderboardProfileList.add(leaderboardProfile);

        leaderboardProfile = new LeaderboardProfile("RP McMurphy", "2", "3");
        mLeaderboardProfileList.add(leaderboardProfile);

        leaderboardProfile = new LeaderboardProfile("Will Hunting", "63", "4");
        mLeaderboardProfileList.add(leaderboardProfile);

        leaderboardProfile = new LeaderboardProfile("Ray Liotta", "40", "5");
        mLeaderboardProfileList.add(leaderboardProfile);

        leaderboardProfile = new LeaderboardProfile("Test Name 2", "5", "6");
        mLeaderboardProfileList.add(leaderboardProfile);

        leaderboardProfile = new LeaderboardProfile("Test Name 2", "17", "7");
        mLeaderboardProfileList.add(leaderboardProfile);

        leaderboardProfile = new LeaderboardProfile("test test test test test test test ", "12", "8");
        mLeaderboardProfileList.add(leaderboardProfile);
    }

    public void returnToProfile(View view) {
        Intent myIntent = new Intent(LeaderboardActivity.this, ProfileActivity.class);
        startActivity(myIntent);
    }
}
