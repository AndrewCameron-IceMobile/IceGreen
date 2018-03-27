package com.icemobile.icegreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardActivity extends AppCompatActivity {

    public void returnToProfile(View view) {
        Intent myIntent = new Intent(LeaderboardActivity.this, ProfileActivity.class);
        startActivity(myIntent);
    }
}
