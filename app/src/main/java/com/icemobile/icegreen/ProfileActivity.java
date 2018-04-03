package com.icemobile.icegreen;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    //AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());

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
