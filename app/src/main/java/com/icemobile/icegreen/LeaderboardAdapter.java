package com.icemobile.icegreen;

/**
 * Created by andrew.cameron on 28/03/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.MyViewHolder> {

    private List<LeaderboardProfile> mLeaderboardProfileList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username, numberOfLeaves, ranking;

        public MyViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.name_space_card);
            numberOfLeaves = (TextView) view.findViewById(R.id.user_total_leaves);
        }
    }

    public LeaderboardAdapter(List<LeaderboardProfile> leaderboardProfileList) {
        mLeaderboardProfileList = leaderboardProfileList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LeaderboardProfile leaderboardProfileList = mLeaderboardProfileList.get(position);
        holder.username.setText(leaderboardProfileList.getUsername());
        holder.numberOfLeaves.setText(leaderboardProfileList.getNumberOfLeaves().toString());
    }

    @Override
    public int getItemCount() {
        return mLeaderboardProfileList.size();
    }
}
