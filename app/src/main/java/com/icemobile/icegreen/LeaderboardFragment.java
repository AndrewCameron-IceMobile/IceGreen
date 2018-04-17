package com.icemobile.icegreen;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by andrew.cameron on 05/04/2018.
 */

public class LeaderboardFragment extends Fragment {

    //Previous Variables
    //--------------------------------------------------
    private List<LeaderboardProfile> mLeaderboardProfileList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private LeaderboardAdapter mAdapter;
    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_leaderboard, parent, false);

        return view;
    }

    public static LeaderboardFragment newInstance(final Bundle extra) {
        LeaderboardFragment fragment = new LeaderboardFragment();
        fragment.setArguments(extra);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        mAdapter = new LeaderboardAdapter(mLeaderboardProfileList);

        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mAdapter);

        prepareLeaderboardProfileData();
    }

    private void prepareLeaderboardProfileData() {

        //------------------------------------------------------------------------------------------
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
}
