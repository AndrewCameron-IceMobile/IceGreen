package com.icemobile.icegreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void goToProfile(View view) {
        Intent myIntent = new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(myIntent);
    }
}
