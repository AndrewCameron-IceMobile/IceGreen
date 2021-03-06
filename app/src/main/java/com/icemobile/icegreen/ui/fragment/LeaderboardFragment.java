package com.icemobile.icegreen.ui.fragment;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icemobile.icegreen.leaderboard.LeaderboardAdapter;
import com.icemobile.icegreen.leaderboard.LeaderboardProfile;
import com.icemobile.icegreen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew.cameron on 05/04/2018.
 */

public class LeaderboardFragment extends Fragment {

    private List<LeaderboardProfile> mLeaderboardProfileList;
    private RecyclerView mRecyclerView;
    private OnFinishedClickListener mOnFinishedClickListener;

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


    public void setOnFinishedClickListener(OnFinishedClickListener onFinishedClickListener) {
        mOnFinishedClickListener = onFinishedClickListener;
    }

    public interface OnFinishedClickListener {
        void OnFinishedClicked();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonFinished = view.findViewById(R.id.btn_session_finished);
        buttonFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnFinishedClickListener.OnFinishedClicked();
            }
        });

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        prepareLeaderboardProfileData();
    }

    private void prepareLeaderboardProfileData() {

        new GetDataFromFirebase().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        // Read from database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Profiles");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mLeaderboardProfileList = new ArrayList<>();

                for (DataSnapshot profileSnapshot: dataSnapshot.getChildren()) {
//                    String iD = (String) profileSnapshot.getKey();
                    String username = (String) profileSnapshot.child("username").getValue();
                    Long numberOfLeaves = (Long) profileSnapshot.child("numberOfLeaves").getValue();
                    String name = (String) profileSnapshot.child("name").getValue();
                    Boolean monPresent = (Boolean) profileSnapshot.child("monPresent").getValue();
                    Boolean tuePresent = (Boolean) profileSnapshot.child("tuePresent").getValue();
                    Boolean wedPresent = (Boolean) profileSnapshot.child("wedPresent").getValue();
                    Boolean thuPresent = (Boolean) profileSnapshot.child("thuPresent").getValue();
                    Boolean friPresent = (Boolean) profileSnapshot.child("friPresent").getValue();

                    LeaderboardProfile leaderboardProfile = new LeaderboardProfile(username, numberOfLeaves, name, monPresent, tuePresent, wedPresent, thuPresent, friPresent);
                    mLeaderboardProfileList.add(leaderboardProfile);
                }
                mRecyclerView.setAdapter(new LeaderboardAdapter(mLeaderboardProfileList));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Failed to read value." + databaseError.toException());
            }
        });
    }

    private class GetDataFromFirebase extends AsyncTask<Void,Void,Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}
