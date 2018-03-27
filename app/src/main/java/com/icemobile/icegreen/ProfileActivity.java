package com.icemobile.icegreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void returnToLogin(View view) {
        Intent myIntent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(myIntent);
    }

    public void goToLeaderboard(View view) {
        Intent myIntent = new Intent(ProfileActivity.this, LeaderboardActivity.class);
        startActivity(myIntent);
    }
}
